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
        UserInterface ui = new UserInterface(p);
        ui.displayMenu();
        String command = scanner.nextLine();
        ui.processCommand(command);
    }
}
