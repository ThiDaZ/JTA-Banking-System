package jta.chopsticks.ee.bank.ejb.remote;


public interface AccountService {
    void creditAccount(String accountNo, double amount);
    void debitAccount(String accountNo, double amount);
}
