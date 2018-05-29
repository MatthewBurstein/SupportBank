package training.supportbank;

public class UserInterface {

    private final Printer printer;
    private final FileService fileService;

    public UserInterface(Printer printer, FileService fileService) {
        this.printer = printer;
        this.fileService = fileService;
    }

    public void displayMenu() {
        System.out.println("what would you like to do?");
        System.out.println("Type 'List All' to list all accounts");
        System.out.println("Type List <Account Name> to list transactions for a specific account");
        System.out.println("Type Import <Filename> to import a new file");
    }

    public void processCommand(String command) {
        if (command.equals("List All")) {
            printer.printAllAccounts();
        } else if (command.startsWith("List ")) {
            String accountName = command.substring(5);
            printer.printAccountHistory(accountName);
        } else if (command.startsWith("Import ")){
            String filename  = command.substring(7);
            fileService.importFile();
        } else {
            System.out.println("I do not know that command");
        }
    }
}
