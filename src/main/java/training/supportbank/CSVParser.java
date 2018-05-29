package training.supportbank;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CSVParser {

    private static final Logger LOGGER = LogManager.getLogger("CSVFileService logger");
    private final String filePath;
    private final ArrayList<String[]> data;

    public CSVParser (String filePath) {
        this.filePath = filePath;
        this.data = new ArrayList<>();
        parseCSV();
    }


    public Set<String> getAccountNames() {
        Set<String> accountNames = data
                .stream()
                .map(line -> line[1])
                .collect(Collectors.toSet());
        Set<String> otherAccountNames = data.stream().map(line -> line[2])
                .collect(Collectors.toSet());
        accountNames.addAll(otherAccountNames);
        return accountNames;
    }

    public List<Transaction> getTransactions() {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        for (String[] transaction : data) {
            transactionList.add(buildTransaction(transaction));
        }
        return transactionList;
    }

    private void parseCSV() {
        FileReader csvData = null;
        try {
            csvData = new FileReader(filePath);
            LOGGER.log(Level.INFO, "File opened:" + filePath);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.ERROR, "File not found: " + filePath);
            System.out.println("Error reading file: " + e.getMessage());
        }
        BufferedReader br = new BufferedReader(csvData);
        br.lines()
                .skip(1)
                .map(line -> line.split(","))
                .forEach(data::add);
    }

    private Transaction buildTransaction(String[] transactionArray){
        return new Transaction(transactionArray[0], transactionArray[1], transactionArray[2], transactionArray[3],transactionArray[4]);
    }
}
