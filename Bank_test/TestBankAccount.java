package Bank_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Bank_system.AmountException;
import Bank_system.BankAccount;

public class TestBankAccount {

	public int select() {

		int selection = 0;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			selection = Integer.parseInt(str);
		} catch (IOException e) {
			System.out.println("An error has occured");
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid option");
			System.exit(0);
		}

		return selection;
	}

	public double chooseAmount() {

		double amount = 0.0;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			amount = Double.parseDouble(str);
		} catch (IOException e) {
			System.out.println("An error has occured");
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid amount");
			System.exit(0);
		}

		return amount;
	}

	public static void main(String[] args) {

		TestBankAccount testing = new TestBankAccount();

		String procedures[] = {"Show balance", "Deposit", "Withdraw"};

		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

		BankAccount testA = new BankAccount("NL1234 1234 1234", "Alice", 99.99);
		BankAccount testB = new BankAccount("GB1234 4321 4321", "Robert", 88.88);
		BankAccount testC = new BankAccount("FR5678 5678 5678", "Pierre", 66.66);

		accounts.add(testA);
		accounts.add(testB);
		accounts.add(testC);

		System.out.println("Choose one of the following accounts:");

		for (BankAccount account : accounts) {
			System.out.println((accounts.indexOf(account) + 1) + ". " +
				account.getAccountNumber());
		}

		int account = testing.select() - 1;

		System.out.println("Choose a procedure:");

		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + ". " + procedures[i]);
		}

		int procedure = testing.select();

		switch(procedure) {
			case 1:
				System.out.println(accounts.get(account).toString());
				break;
			case 2:
				try {
					System.out.println("Enter amount to deposit:");
					double amount = testing.chooseAmount();
					accounts.get(account).deposit(amount);
				} catch (AmountException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Enter amount to withdraw:");
					double amount = testing.chooseAmount();
					accounts.get(account).withdraw(amount);
				} catch (AmountException e) {
					System.out.println(e.getMessage());
				}
				break;
		}

	}

}
