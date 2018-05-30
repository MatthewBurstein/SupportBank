package training.supportbank;

import org.junit.jupiter.api.Test;
import training.supportbank.FileService;
import training.supportbank.Transaction;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileServiceTest {

    @Test
    public void getTransactionsImportsCSVTransactions() {
        FileService fs = new FileService("./TestTransactions.csv");
        Transaction transaction1 = new Transaction("01/01/2014", "Jon A", "Sarah T", "Pokemon Training", "7.8");
        Transaction transaction2 = new Transaction("04/01/2014", "Stephen S", "Tim L", "Lunch", "4.37");
        Transaction transaction3 = new Transaction("08/01/2014", "Laura B", "Stephen S", "Lunch", "5.09");
        List<Transaction> expected = new ArrayList<>();
        expected.add(transaction1);
        expected.add(transaction2);
        expected.add(transaction3);
        assertEquals(expected, fs.getTransactions());
    }

    @Test
    public void getTransactionsImportsJSONTransactions() {
        FileService fs = new FileService("TestTransactions.json");
        List<Transaction> expected = new ArrayList<>();
        Transaction transaction1 = new Transaction("01/01/2013", "Jon A", "Gergana I", "Sandbox Help", "2.14");
        Transaction transaction2 = new Transaction("04/01/2013", "Chris W", "Dan W", "Coffee", "10.53");
        Transaction transaction3 = new Transaction("05/01/2013", "Stephen S", "Tim L", "Sandcastle Help", "10.57");
        expected.add(transaction1);
        expected.add(transaction2);
        expected.add(transaction3);
        assertEquals(expected, fs.getTransactions());
    }

    @Test
    public void getAccountNamesReturnsAccountNames() {
        FileService fs = new FileService("TestTransactions.json");
        Set<String> expected = new HashSet<>();
        String[] names = {"Chris W", "Gergana I", "Tim L", "Jon A", "Stephen S", "Dan W"};
        expected.addAll(Arrays.asList(names));
        assertEquals(expected, fs.getAccountNames());
    }
}
