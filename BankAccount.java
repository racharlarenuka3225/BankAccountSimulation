package advJava;
import java.util.Scanner;
public class BankAccount {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Apply Interest (Savings Only)");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            String accNum;
            Account acc;

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.next();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Type (1-Savings, 2-Current): ");
                    int type = sc.nextInt();

                    if (type == 1) {
                        Bank.createAccount(new SavingsAccount(accNum, name, bal));
                    } else if (type == 2) {
                        Bank.createAccount(new CurrentAccount(accNum, name, bal));
                    } else {
                        System.out.println("Invalid account type!");
                    }
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    accNum = sc.next();
                    acc = Bank.findAccount(accNum);
                    if (acc != null) {
                        System.out.print("Amount: ");
                        acc.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    accNum = sc.next();
                    acc = Bank.findAccount(accNum);
                    if (acc != null) {
                        System.out.print("Amount: ");
                        acc.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("From Account: ");
                    String from = sc.next();
                    System.out.print("To Account: ");
                    String to = sc.next();
                    System.out.print("Amount: ");
                    Bank.transferMoney(from, to, sc.nextDouble());
                    break;

                case 5:
                    System.out.print("Account Number: ");
                    accNum = sc.next();
                    acc = Bank.findAccount(accNum);
                    if (acc != null) {
                        System.out.println("Balance: " + acc.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.print("Account Number: ");
                    accNum = sc.next();
                    acc = Bank.findAccount(accNum);
                    if (acc instanceof SavingsAccount) {
                        acc.calculateInterest();
                    } else if (acc instanceof CurrentAccount) {
                        acc.calculateInterest(); // just prints "No interest"
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 7:
                    System.out.println("Thank You For Visiting !");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
