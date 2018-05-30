package training.supportbank;

import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileService {

    private final String filePath;
    private List<Transaction> transactions;
    private final String extension;

    public FileService(final String filePath) {
        this.filePath = filePath;
        this.transactions = new ArrayList<>();
        this.extension = FilenameUtils.getExtension(filePath);
        buildTransactionsFromFile();
    }

    public final Set<String> getAccountNames() {
        Set<String> accountNames = transactions
                .stream()
                .map(Transaction::getFromAccount)
                .collect(Collectors.toSet());
        Set<String> otherAccountNames = transactions
                .stream()
                .map(Transaction::getToAccount)
                .collect(Collectors.toSet());
        accountNames.addAll(otherAccountNames);
        return accountNames;
    }

    public final List<Transaction> getTransactions() {
        return transactions;
    }

    public final void buildTransactionsFromFile() {
        if (extension.equals("csv")) {
            transactions = getTransactionsFromCsv();
        } else if (extension.equals("json")) {
            transactions = getTransactionsFromJson();
        } else {
            System.out.println("I do not know that file extension");
        }
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
