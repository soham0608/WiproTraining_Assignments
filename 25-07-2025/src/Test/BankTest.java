package Test;

import AnynoumsFunct.BankOps;

public class BankTest {
	
	public static void main(String[] args) {

        BankOps savingsAccount = new BankOps() {
            double balance = 0;

            @Override
            public void deposit(double amount) {
                balance += amount;
                System.out.println("Deposited " + amount + " in Savings Account. New balance: " + balance);
            }
        };

        BankOps currentAccount = new BankOps() {
            double balance = 0;

            @Override
            public void deposit(double amount) {
                balance += amount;
                System.out.println("Deposited " + amount + " in Current Account. New balance: " + balance);
            }
        };

        savingsAccount.deposit(5000);
        currentAccount.deposit(10000);
    }
}
