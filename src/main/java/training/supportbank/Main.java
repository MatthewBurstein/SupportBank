package training.supportbank;

import javax.sql.rowset.spi.TransactionalWriter;

public class Main {
    public static void main(String args[]) {
        Bank bank = new Bank();
        FileService fs = new FileService("./Transactions2014.csv");
        fs.createAccounts(bank);
        bank.getAccounts().forEach(account -> System.out.println(account.getName()));
    }
}
