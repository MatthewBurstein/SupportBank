import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import training.supportbank.Bank;
import training.supportbank.FileService;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileServiceTest {

    FileService fs = new FileService("./TestTransactions.csv");
    Bank bank = new Bank();

    @Test
    public void returnsABufferedReaderOfTheCSVFile() {
        fs.createAccounts(bank);
//        br.lines()
//                .map(line -> line.split(","))
//                .forEach(line-> System.out.println(Arrays.toString(line)));
    }

}
