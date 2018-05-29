package training.supportbank;

import org.apache.commons.io.FilenameUtils;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import java.util.List;

public class FileService{

    private final String filePath;
    private List<Transaction> transactions;
    private final String extension;

    public FileService(String filePath) {
        this.filePath = filePath;
        this.transactions = new ArrayList<>();
        this.extension = FilenameUtils.getExtension(filePath);
    }

    public void importFile() {

    }

    public List<Transaction> getTransactions() {
        if (extension.equals("csv")) {
            transactions = getTransactionsFromCsv();
        } else if (extension.equals("json")) {
            transactions = getTransactionsFromJson();
        } else {
            System.out.println("I do not know that file extension");
        }
        return transactions;
    }

    private List<Transaction> getTransactionsFromCsv() {
        CSVParser parser = new CSVParser(filePath);
        return parser.getTransactions();
    }

    private List<Transaction> getTransactionsFromJson() {
        JSONParser parser = new JSONParser(filePath);
        return parser.getTransactions();
    }
}
