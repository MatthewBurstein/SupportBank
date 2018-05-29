import org.junit.jupiter.api.Test;
import training.supportbank.JSONFileService;
import training.supportbank.Transaction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JSONFileServiceTest {

    JSONFileService fs = new JSONFileService("TestTransactions.json");

    @Test
    public void parseProcessesTransactionsCorrectly() {
        List<Transaction> expected = new ArrayList<>();
        Transaction transaction1 = new Transaction("01/01/2013", "Jon A", "Gergana I", "Sandbox Help", "2.14");
        Transaction transaction2 = new Transaction("04/01/2013", "Chris W", "Dan W", "Coffee", "10.53");
        Transaction transaction3 = new Transaction("05/01/2013", "Stephen S", "Tim L", "Sandcastle Help", "10.57");
        expected.add(transaction1);
        expected.add(transaction2);
        expected.add(transaction3);
        List<Transaction> actual = fs.parse();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
