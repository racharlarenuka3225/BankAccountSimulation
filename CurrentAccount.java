package advJava;
public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("No interest for Current Account.");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && getBalance() - amount >= -OVERDRAFT_LIMIT) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
            return true;
        } else {
            System.out.println("Overdraft limit exceeded!");
            return false;
        }
    }
}
