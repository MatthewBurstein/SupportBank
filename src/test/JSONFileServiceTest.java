import org.junit.jupiter.api.Test;
import training.supportbank.JSONParser;
import training.supportbank.Transaction;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONFileServiceTest {

    JSONParser parser = new JSONParser("TestTransactions.json");

    @Test
    public void getTransactionsReturnsListOfTransactions() {
        List<Transaction> expected = new ArrayList<>();
        Transaction transaction1 = new Transaction("01/01/2013", "Jon A", "Gergana I", "Sandbox Help", "2.14");
        Transaction transaction2 = new Transaction("04/01/2013", "Chris W", "Dan W", "Coffee", "10.53");
        Transaction transaction3 = new Transaction("05/01/2013", "Stephen S", "Tim L", "Sandcastle Help", "10.57");
        expected.add(transaction1);
        expected.add(transaction2);
        expected.add(transaction3);
        assertEquals(expected, parser.getTransactions());
    }

    @Test
    public void getAccountNamesReturnsAccountNames() {
        Set<String> expected = new HashSet<>();
        String[] names = {"Chris W", "Gergana I", "Tim L", "Jon A", "Stephen S", "Dan W"};
        expected.addAll(Arrays.asList(names));
        assertEquals(expected, parser.getAccountNames());
    }
}
