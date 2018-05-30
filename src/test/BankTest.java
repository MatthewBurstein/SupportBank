import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.supportbank.Account;
import training.supportbank.Bank;
import training.supportbank.Transaction;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    Bank bank;

    @BeforeEach
    public void createBank() {
        bank = new Bank();
    }

    @Test
    public void addAccountAddsAccountToBank() {
        Account account = new Account("accountName");
        Map<String, Account> expected = new HashMap<>();
        expected.put("accountName", account);
        bank.addAccount("accountName");
        assertEquals(expected, bank.getAccounts());
    }

    @Test
    public void addAccountDoesNotAddAccountIfNameAlreadyExists() {
//        Account firstAccount = new Account("accountName");
//        Transaction transaction = new Transaction("01/01/2014", "accountName", "anotherAccount", "narrative", "10");
//        firstAccount.processTransaction(transaction);
//        System.out.println(firstAccount.getBalance());
//        bank.addAccount("accountName");
//        Map<String, Account> expected = new HashMap<>();
//        expected.put("accountName", firstAccount);
//        assertEquals(expected, bank.getAccounts());
    }

    @Test
    public void addMultipleAccountsAddsMultipleAccountsToBank() {
        HashMap<String, Account> expected = new HashMap<>();
        Account account1 = new Account("account1");
        Account account2 = new Account("account2");
        expected.put("account1", account1);
        expected.put("account2", account2);
        Set<String> accountsToAdd = new HashSet<>();
        accountsToAdd.add("account1");
        accountsToAdd.add("account2");
        bank.addMultipleAccounts(accountsToAdd);
        assertEquals(expected, bank.getAccounts());
    }
}
