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
        CSVFileService csvFs = new CSVFileService("./Transactions2014.csv");
        CSVFileService dodgyFs = new CSVFileService("./DodgyTransactions2015.csv");
        JSONFileService jsonFs = new JSONFileService("./Transactions2013.json");
        Printer p = new Printer(bank);
        UserInterface ui = new UserInterface(p);
        bank.addMultipleAccounts(csvFs.getAccountNames());
        bank.processMultipleTransactions(csvFs.getTransactions());
        bank.addMultipleAccounts(dodgyFs.getAccountNames());
        bank.processMultipleTransactions(dodgyFs.getTransactions());
        bank.addMultipleAccounts(jsonFs.getAccountNames());
        bank.processMultipleTransactions(jsonFs.getTransactions());
        ui.displayMenu();
        String command = scanner.nextLine();
        ui.processCommand(command);
    }

}