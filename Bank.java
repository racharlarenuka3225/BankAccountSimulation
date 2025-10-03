package advJava;
import java.util.ArrayList;
import java.util.List;
public class Bank {
    private static List<Account> accounts = new ArrayList<>();
    public static void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created for: " + account.getAccountHolder());
    }
    public static Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
    public static void transferMoney(String fromAccNum, String toAccNum, double amount) {
        Account from = findAccount(fromAccNum);
        Account to = findAccount(toAccNum);

        if (from != null && to != null) {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transfer complete!");
        } else {
            System.out.println("Account not found!");
        }
    }
}
