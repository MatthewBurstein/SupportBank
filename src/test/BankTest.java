import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.supportbank.Account;
import training.supportbank.Bank;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
    public void addMultipleAccountsAddsMultipleAccountsToBank() {
//        List<Account> expected = new ArrayList<>();
//        Account account1 = new Account("account1");
//        Account account2 = new Account("account2");
//        expected.add(account1);
//        expected.add(account2);
//        Set<String> accountsToAdd = new HashSet<>();
//        accountsToAdd.add("account1");
//        accountsToAdd.add("account2");
//        bank.addMultipleAccounts(accountsToAdd);
//        ArrayList<String> accountNames = bank.getAccounts().map(account -> account.getName());
//        assertEquals(expected, bank.getAccounts());
    }

//    @Test
//    public void addTransactionAddsTransactionToBank() {
//        Transaction transaction = new Transaction
//    }
}
