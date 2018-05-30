package training.supportbank;

public class UserInterface {

    private final Printer printer;
    private final Bank bank;
    private boolean running;

    public UserInterface(Printer printer, Bank bank) {
        this.printer = printer;
        this.bank = bank;

        this.running = true;
    }

    public boolean isRunning() {
        return running;
    }

    public void displayMenu() {
        System.out.println("what would you like to do?");
        System.out.println("Available commands:");
        System.out.println("'List All' => list all accounts");
        System.out.println("'List <Account Name>' => list transactions for a specific account");
        System.out.println("'Import <Filename>' => import a new file");
        System.out.println("'Exit' => exit program");
    }

    public void processCommand(String command) {
        if (command.equals("List All")) {
            printer.printAllAccounts();
        } else if (command.startsWith("List ")) {
            String accountName = command.substring(5);
            printer.printAccountHistory(accountName);
        } else if (command.startsWith("Import ")) {
            String filePath = command.substring(7);
            FileService fs = new FileService(filePath);
            bank.addMultipleAccounts(fs.getAccountNames());
            bank.processMultipleTransactions(fs.getTransactions());
        } else if (command.equals("Exit")){
            running = false;
        } else {
            System.out.println("I do not know that command");
        }
    }
}
