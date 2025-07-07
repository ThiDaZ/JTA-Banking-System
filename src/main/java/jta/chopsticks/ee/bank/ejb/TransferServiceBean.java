package jta.chopsticks.ee.bank.ejb;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jta.chopsticks.ee.bank.ejb.remote.AccountService;
import jta.chopsticks.ee.bank.ejb.remote.TransferService;

@Stateless
public class TransferServiceBean implements TransferService {

    @EJB
    private AccountService accountService;

    @Override
    public void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount) {
        accountService.debitAccount(sourceAccountNo, amount);
        accountService.creditAccount(destinationAccountNo, amount);
    }
}
