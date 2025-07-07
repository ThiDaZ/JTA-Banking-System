package jta.chopsticks.ee.bank.ejb;

import jta.chopsticks.ee.bank.ejb.remote.TransferService;

public class TransferServiceBean implements TransferService {
    @Override
    public void transferAmount(String sourceAccountNo, String destinationAccountNo, double amount) {

    }
}
