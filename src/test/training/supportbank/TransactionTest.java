package training.supportbank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionTest {

    Transaction valid = new Transaction("22/07/2017", "personFrom", "personTo", "narrative", "21.70");

    @Test
    public void isValidReturnsFalseWhenAmountInvalid() {
        Transaction invalid = new Transaction("01/01/2014", "oneAccount", "anotherAccount", "narrative", "ten");
        assertFalse(invalid.isValid());
    }


    @Test
    public void isValidReturnsFalseWhenDateInvalid() {
        Transaction invalid = new Transaction("not a date", "oneAccount", "anotherAccount", "narrative", "10");
        assertFalse(invalid.isValid());
    }

    @Test
    public void isValidReturnsTrueWhenTransactionValid() {
        assertTrue(valid.isValid());
    }

}
