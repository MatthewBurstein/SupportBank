package training.supportbank;

import javax.sql.rowset.spi.TransactionalWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        FileService fs = new FileService("./Transactions2014.csv");
        Printer p = new Printer(bank);
        bank.addMultipleAccounts(fs.getAccountNames());
        bank.processMultipleTransactions(fs.getTransactions());
        System.out.println("what would you like to do?");
        System.out.println("Type 'List All' to list all accounts");
        System.out.println("Type List <Account Name> to list transactions for a specific account");
        String command = scanner.nextLine();
        if (command.equals("List All")) {
            p.printAllAccounts();
        } else if (command.startsWith("List ")) {
            String accountName = command.substring(5);
            p.printAccountHistory(accountName);
        } else {
            System.out.println("I do not know that command");
        }

    }
}
