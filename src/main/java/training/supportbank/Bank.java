package training.supportbank;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Bank {

    private static final Logger LOGGER = LogManager.getLogger("Bank logger");

    private static HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }
    
    public static HashMap<String, Account> getAccounts() {return accounts;}

    public void addAccount(String name) {
        if(accounts.get(name) == null) {
            Account account = new Account(name);
            accounts.put(name, account);
            LOGGER.log(Level.INFO, "Account created for: " + name);
        }
    }

    public void addMultipleAccounts(Set<String> accountNames) {
        accountNames.forEach(this::addAccount);
    }

    private void processTransaction(Transaction transaction) {
            accounts.get(transaction.getFromAccount()).processTransaction(transaction);
            accounts.get(transaction.getToAccount()).processTransaction(transaction);
    }

    void processMultipleTransactions(List<Transaction> transactions) {
        transactions.forEach(transaction -> processTransaction(transaction));
    }
}
