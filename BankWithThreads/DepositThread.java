package BankWithThreads;

import java.util.ArrayList;
import java.util.Random;

public class DepositThread extends Thread {

	private BankAccount account;
	private double amount;

	public DepositThread(BankAccount account, double amount) {
		this.account = account;
		this.amount = amount;
	}

	public BankAccount getAccount() {
		return account;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public void run() {

		try {
			account.deposit(amount);
		} catch (AmountException e) {
			System.out.println(e.getMessage());
		}

	}


	public static void main(String[] args) {

		BankAccount accountA = new BankAccount(88.88);
		ArrayList<DepositThread> threads = new ArrayList<DepositThread>();
		Random rand = new Random();

		for (int i = 0; i < 3; i++) {
			double amount = Math.floor(9999 * rand.nextDouble() + 1) / 100;
			threads.add(new DepositThread(accountA, amount));
		}

		for (DepositThread thread : threads) {
			thread.start();
		}

		for (DepositThread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(accountA.toString());

	}

}
