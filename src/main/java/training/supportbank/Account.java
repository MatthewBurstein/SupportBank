package training.supportbank;

public class Account {

    private final String name;
    private final Float balance;

    public Account(String name) {
        this.name = name;
        this.balance = Float.valueOf(0);
    }

    public String getName() {
        return name;
    }

}
