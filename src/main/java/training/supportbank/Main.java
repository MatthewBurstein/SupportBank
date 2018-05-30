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
        Printer printer = new Printer(bank);
        FileService fs = new FileService("./Transactions2014.csv");
        UserInterface ui = new UserInterface(printer, bank);
        while (ui.isRunning()) {
            ui.displayMenu();
            String command = scanner.nextLine();
            ui.processCommand(command);
        }
    }

}