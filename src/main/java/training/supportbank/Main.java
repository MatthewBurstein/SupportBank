package training.supportbank;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger("Main logger");

    public static void main(String args[]) {

        LOGGER.log(Level.INFO, "Program starting");

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        CSVFileService fs = new CSVFileService("./Transactions2014.csv");
        CSVFileService dodgyfs = new CSVFileService("./DodgyTransactions2015.csv");
//        JSONFileService jsonFileService = new JSONFileService("./Transactions2013.json");
        Printer p = new Printer(bank);
        UserInterface ui = new UserInterface(p);
        bank.addMultipleAccounts(fs.getAccountNames());
        bank.processMultipleTransactions(fs.getTransactions());
        bank.addMultipleAccounts(dodgyfs.getAccountNames());
        bank.processMultipleTransactions(dodgyfs.getTransactions());
        ui.displayMenu();
        String command = scanner.nextLine();
        ui.processCommand(command);
    }

}