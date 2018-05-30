package training.supportbank;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.supportbank.Account;
import training.supportbank.Bank;
import training.supportbank.Transaction;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {

    Bank bank;

    @BeforeEach
    public void createBank() {
        bank = new Bank();
    }

    @Test
    public void addMulitpleAccountsDoesNotAddAccountIfNameAlreadyExists() {
        Set<String> accounts = Sets.newHashSet("accountName", "anotherAccount");
        bank.addMultipleAccounts(accounts);
        Transaction transaction = new Transaction("01/01/2014", "accountName", "anotherAccount", "narrative", "10");
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        bank.processMultipleTransactions(transactions);
        Set<String> newAccounts = Sets.newHashSet("accountName");
        bank.addMultipleAccounts(newAccounts);
        BigDecimal expected = new BigDecimal(-10);
        BigDecimal actual =  bank.getAccounts().get("accountName").getBalance();
        assertEquals(expected,actual);
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

    @Test
    public void processTransactionsDoesNotProcessInvalidTransactions() {
        Set<String> accounts = Sets.newHashSet("accountName", "anotherAccount");
        bank.addMultipleAccounts(accounts);
        Transaction transaction = new Transaction("not a date", "accountName", "anotherAccount", "narrative", "10");
        List<Transaction> transactions = Lists.newArrayList(transaction);
        bank.processMultipleTransactions(transactions);
        assertTrue(bank.getAccounts().get("accountName").getTransactions().isEmpty());
        assertTrue(bank.getAccounts().get("anotherAccount").getTransactions().isEmpty());
    }
}
