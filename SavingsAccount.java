package advJava;
	public class SavingsAccount extends Account {
	    private static final double INTEREST_RATE = 0.04; // 4% interest

	    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
	        super(accountNumber, accountHolder, balance);
	    }

	    @Override
	    public void calculateInterest() {
	        double interest = getBalance() * INTEREST_RATE;
	        deposit(interest);
	        System.out.println("Interest added: " + interest);
	    }
	}
