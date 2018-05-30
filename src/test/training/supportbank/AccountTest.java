package training.supportbank;

import org.junit.jupiter.api.Test;
import training.supportbank.Account;
import training.supportbank.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountTest {

    Account account = new Account("accountName");

    @Test
    public void processTransactionDebitReducesBalance() {
        Transaction transaction = new Transaction("01/01/2017", "accountName", "anotherAccount", "someNarrative", "1.4");
        account.processTransaction(transaction);
        BigDecimal expected = new BigDecimal("-1.4");
        assertEquals(account.getBalance(), expected);
    }

    @Test
    public void processTransactionCrebitIncreasesBalance() {
        Transaction transaction = new Transaction("01/01/2017", "anotherAccount", "accountName", "someNarrative", "1.4");
        account.processTransaction(transaction);
        BigDecimal expected = new BigDecimal("1.4");
        assertEquals(account.getBalance(), expected);
    }

    @Test
    public void processTransactionAddsTransactionToTransactions() {
        Transaction transaction = new Transaction("01/01/2017", "anotherAccount", "accountName", "someNarrative", "1.4");
        ArrayList<Transaction> expected = new ArrayList<>();
        expected.add(transaction);
        account.processTransaction(transaction);
        assertEquals(account.getTransactions(), expected);
    }

}
