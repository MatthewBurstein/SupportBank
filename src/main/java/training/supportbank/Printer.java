package training.supportbank;

public class Printer {

    private final Bank bank;

    public Printer(final Bank bank) {
        this.bank = bank;
    }

    public final void printAllAccounts() {
        bank.getAccounts().forEach((accountName, account) -> printAccount(account));
    }

    public final void printAccount(final Account account) {
        System.out.println( account.getName() + ": £" + account.getBalance());
    }

    public void printAccountHistory(final String accountName) {
        Account account = bank.getAccounts().get(accountName);
        account.getTransactions().forEach(transaction -> printTransaction(transaction, accountName));
    }

    public void printTransaction(final Transaction transaction, final String accountName) {
        String transactionType = "";
        if (accountName.equals(transaction.getFromAccount())) {
            transactionType = "debit";
        } else if (accountName.equals(transaction.getToAccount())) {
            transactionType = "credit";
        }
        System.out.println(transaction.getDate() + " " +
            transactionType + " £" +
            transaction.getAmount() + " " +
            transaction.getNarrative());
    }
}
