import org.junit.jupiter.api.Test;
import training.supportbank.CSVFileService;
import training.supportbank.Transaction;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFileServiceTest {

    CSVFileService fs = new CSVFileService("./TestTransactions.csv");

    @Test
    public void returnsASetOfAccountNames() {
        Set<String> expected = new HashSet<String>();
        String[] names = {"Sarah T", "Laura B", "Tim L", "Jon A", "Stephen S"};
        expected.addAll(Arrays.asList(names));
        assertEquals(expected, fs.getAccountNames());
    }

    @Test
    public void returnsAListOfTransactions() {
        Transaction transaction1 = new Transaction("01/01/2014", "Jon A", "Sarah T", "Pokemon Training", "7.8");
        Transaction transaction2 = new Transaction("04/01/2014", "Stephen S", "Tim L", "Lunch", "4.37");
        Transaction transaction3 = new Transaction("08/01/2014", "Laura B", "Stephen S", "Lunch", "5.09");
        List<Transaction> expected = new ArrayList<>();
        expected.add(transaction1);
        expected.add(transaction2);
        expected.add(transaction3);
        List<Transaction> actual = fs.getTransactions();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }


}
