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
        CSVParser csvFs = new CSVParser("./Transactions2014.csv");
        CSVParser dodgyFs = new CSVParser("./DodgyTransactions2015.csv");
        JSONParser jsonFs = new JSONParser("./Transactions2013.json");
        Printer p = new Printer(bank);
        FileService fs = new FileService("./Transactions2014.csv");
        UserInterface ui = new UserInterface(p, fs);
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