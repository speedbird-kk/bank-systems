package BankWithThreads;

public class BankAccount {

	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void deposit(double amount) throws AmountException {

		if (amount <= 0) {
			throw new AmountException("Failed to deposit. Please enter a positive amount");
		} else {
			balance += amount;
			System.out.println("Successfullly deposited " + amount +
					" Euros to account");
			System.out.println("Updated balance: " + balance);
		}
	}

	public String toString() {
		return "Final balance: " + String.format("%.2f", balance) + " Euros";
	}
}
