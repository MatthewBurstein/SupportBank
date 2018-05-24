package training.supportbank;

import java.util.ArrayList;
import java.util.Set;

public class Bank {


    private static ArrayList<Account> accounts;

    public Bank() {
        System.out.println("Bank created");
        this.accounts = new ArrayList<Account>();
    }
    
    public static ArrayList<Account> getAccounts() {return accounts;}

    public void addAccount(String name) {
        Account account = new Account(name);
        accounts.add(account);
    }

    public void addMultipleAccounts(Set<String> accountNames) {
        accountNames.forEach(name -> addAccount(name));
    }
}
