package training.supportbank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    private final String fromAccount;
    private final String toAccount;
    private final String narrative;
    private final float amount;

    public Transaction(String date, String fromAccount, String toAccount, String narrative, String amount) {
        this.date = convertDateType(date);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.narrative = narrative;
        this.amount = getAmount(amount);
    }

    public String getFromAccount() {return fromAccount;}

    public String getToAccount() {return toAccount;}

    public float getAmount() {return amount;}

    public LocalDate getDate() {
        return date;
    }

    public String getNarrative() {
        return narrative;
    }

    private LocalDate convertDateType(String date) {
        LocalDate dateObject = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dateObject = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e){
            LOGGER.log(Level.ERROR, "Transaction failed - invalid date{from: " + fromAccount + ", to: " + toAccount + ", date: " + date + "}");
        }
        return dateObject;
    }

    private float getAmount(String amount) {
        float amountFloat = 0;
        try {
            amountFloat = Float.parseFloat(amount);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.ERROR, "Transaction failed - invalid amount{from: " + fromAccount + ", to: " + toAccount + ", date: " + date + "}");
        }
        return amountFloat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) { return false; }
        Transaction rhs = (Transaction) obj;
        return new EqualsBuilder()
                .append(date, rhs.getDate())
                .append(fromAccount, rhs.getFromAccount())
                .append(toAccount, rhs.getToAccount())
                .append(amount, rhs.getAmount())
                .append(narrative, rhs.getNarrative())
                .isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
            builder.append(date)
                .append(fromAccount)
                .append(toAccount)
                .append(amount)
                .append(narrative);
        return builder.toHashCode();
    }

}
