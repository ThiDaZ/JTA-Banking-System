package jta.chopsticks.ee.bank.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jta.chopsticks.ee.bank.ejb.remote.AccountService;
import jta.chopsticks.ee.bank.entity.Account;

@Stateless
public class AccountServiceBean implements AccountService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void creditAccount(String accountNo, double amount) {
        try {
            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNo)
                    .getSingleResult();

            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
            }

            em.merge(account);

        } catch (NoResultException e) {
            e.printStackTrace();
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void debitAccount(String accountNo, double amount) {
        try {

            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNo)
                    .getSingleResult();

            if (amount > 0) {
                account.setBalance(account.getBalance() - amount);
            }

            em.merge(account);

        } catch (NoResultException e) {
            e.printStackTrace();
        }
    }
}
