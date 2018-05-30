package training.supportbank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String name;
    private List<Transaction> transactions;
    private BigDecimal balance;

    public Account(final String name) {
        this.name = name;
        this.balance = BigDecimal.valueOf(0);
        this.transactions = new ArrayList<>();
    }

    final String getName() {
        return name;
    }

    final BigDecimal getBalance() {
        return balance;
    }

    public final List<Transaction> getTransactions() {
        return transactions;
    }

    final void processTransaction(Transaction transaction) {
        if (name.equals(transaction.getFromAccount())) {
            debit(transaction.getAmount());
        } else if (name.equals(transaction.getToAccount())) {
            credit(transaction.getAmount());
        }
        transactions.add(transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
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

    private void debit(final BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    private void credit(final BigDecimal amount) {
        balance = balance.add(amount);
    }
}
