package Bank_system;

public class BankAccount {

	private String accountNumber;
	private String owner;
	private double balance;

	public BankAccount(String accountNumber, String owner, double balance) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) throws AmountException {

		if (amount <= 0) {
			throw new AmountException("Failed to deposit. Please enter a positive amount");
		} else {
			balance += amount;
			System.out.println("Successfully deposited " + amount +
					" Euros to account " + accountNumber);
			System.out.println("Updated balance: " + balance);
		}

	}

	public void withdraw(double amount) throws AmountException {

		if (amount > balance) {
			throw new AmountException("Insufficient balance to withdraw " + amount + " Euros.");
		} else {
			balance -= amount;
			System.out.println("Successfully withdrew " + amount +
					" Euros from account " + accountNumber);
			System.out.println("Updated balance: " + balance);
		}

	}

	public String toString() {
		return "Account number: " + accountNumber + "\n" +
				"Owner: " + owner + "\n" +
				"Balance: " + balance;
	}

}
