package training.supportbank;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Transaction {

    private static final Logger LOGGER = LogManager.getLogger("Transaction logger");
    private final LocalDate date;
    private final String from;
    private final String to;
    private final String narrative;
    private final float amount;

    public Transaction(String date, String from, String to, String narrative, String amount) {
        this.date = getDate(date);
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = getAmount(amount);
    }

    public String getFrom() {return from;}

    public String getTo() {return to;}

    public float getAmount() {return amount;}

    public LocalDate getDate() {
        return date;
    }

    public String getNarrative() {
        return narrative;
    }

    private LocalDate getDate(String date) {
        LocalDate dateObject = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dateObject = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e){
            LOGGER.log(Level.ERROR, "Transaction failed - invalid date{from: " + from + ", to: " + to + ", date: " + date + "}");
        }
        return dateObject;
    }

    private float getAmount(String amount) {
        float amountFloat = 0;
        try {
            amountFloat = Float.parseFloat(amount);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARN, "Transaction failed - invalid amount{from: " + from + ", to: " + to + ", date: " + date + "}");
        }
        return amountFloat;
    }

}
