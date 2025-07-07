package jta.chopsticks.ee.bank.ejb;

import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.*;
import jta.chopsticks.ee.bank.ejb.remote.AccountService;
import jta.chopsticks.ee.bank.ejb.remote.TransferService;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TransferServiceBean implements TransferService {

    @EJB
    private AccountService accountService;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    @Override
//    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount) {

        try {
            utx.begin();

            accountService.debitAccount(sourceAccountNo, amount);
            accountService.creditAccount(destinationAccountNo, amount);

            utx.commit();

        } catch (NotSupportedException e) {
            try {
                utx.rollback();
            } catch (SystemException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }



    }
}
