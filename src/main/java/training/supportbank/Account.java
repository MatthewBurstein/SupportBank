package training.supportbank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String name;
    private List<Transaction> transactions;
    private Float balance;

    public Account(String name) {
        this.name = name;
        this.balance = Float.valueOf(0);
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Float getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void processTransaction(Transaction transaction) {
        if (name.equals(transaction.getFromAccount())) {
            debit(transaction.getAmount());
        } else if (name.equals(transaction.getToAccount())) {
            credit(transaction.getAmount());
        }
        transactions.add(transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) { return false; }
        Account rhs = (Account) obj;
        return new EqualsBuilder()
                .append(name, rhs.getName())
                .append(balance, rhs.getBalance())
                .append(transactions, rhs.getTransactions())
                .isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(name)
                .append(balance)
                .append(transactions);
        return builder.toHashCode();
    }

    private void debit(Float amount) {
        balance -= amount;
    }

    private void credit(Float amount) {
        balance += amount;
    }
}
