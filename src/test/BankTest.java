import org.junit.jupiter.api.Test;
import training.supportbank.Account;
import training.supportbank.Bank;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    Bank bank = new Bank();

    @Test
    public void addAccountAddsAccountToBank() {
        Account account = new Account("accountName");
        List<Account> expected = new ArrayList<Account>();
        expected.add(account);
        bank.addAccount("accountName");
        assertEquals(expected, bank.getAccounts());
    }
}
