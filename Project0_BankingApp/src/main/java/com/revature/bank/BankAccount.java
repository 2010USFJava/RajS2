package com.revature.bank;

import java.io.Serializable;
import java.util.Scanner;

import com.revature.menu.Menu;
import com.revature.util.Database;
import com.revature.util.FileIO;
import com.revature.util.Logging;

public class BankAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1437419025696394866L;
	private double balance;
	private double amount;
	private static int accountNumber = 1000;
	
	public BankAccount() {
		super();
		Database.accountList.add(this);
		Logging.LogIt("info", "An empty account has been added");
	}
	
	public BankAccount(double balance, double amount, int accountNumber) {
		super();
		this.balance = balance;
		this.amount = amount;
		this.accountNumber = accountNumber++;
		Database.accountList.add(this);
		FileIO.writeAccountFile(Database.accountList);
		Logging.LogIt("info", "An account has been added");
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		BankAccount.accountNumber = accountNumber;
	}

	 @Override
	public String toString() {
		return "BankAccount [balance=" + balance + ", amount=" + amount + ", accountNumber=" + accountNumber + "]";
	}

	transient Scanner sc = new Scanner(System.in);
	static Customer c = new Customer();
	public static final int LENGTH = 5;
	
	public boolean validate(String input) { //can't check if username is already used because returns username not found
		if(input.length() < LENGTH) { // || (Database.findCustomerByUsername(input).equals(c.getUsername()))) {
			System.out.println("Invalid! Please try again.");
			return false;
		}
		int numberOfNums = 0, numberOfCh = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				numberOfNums++;
			} else if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z' || input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
				numberOfCh++;
			} else {
				return false;
			}
		}
		if (numberOfNums > 0 && numberOfCh > 0) {
			return true;
		}
		return false;
	}
	
	// Open account
	public void openAccount() {
		String username, password;
		do {
			System.out.println("Enter username (Must be at least " + LENGTH + " characters long and consist of both letters & numbers): ");
			username = sc.nextLine();
		} while (!validate(username));
		System.out.println("Username is valid.");
		c.setUsername(username);
		
		do {
			System.out.println("Enter password (Must be at least " + LENGTH + " characters long and consist of both letters & numbers):");
			password = sc.nextLine();
			if(c.getUsername().equals(password)) {
				System.out.println("Password cannot be the same as username. Please try again.");
				System.out.println("Enter password (Must be at least 7 characters long and consist of both letters & numbers only):");
				password = sc.nextLine();
			}
		} while (!validate(password));
		System.out.println("Password is valid.");
		c.setPassword(password);
		
		chooseAccountType();
	}
	
	public void chooseAccountType() {
		System.out.println("Would you like to make a single account or a joint account? (s/j)");
		String response = sc.nextLine();
		while(!(response.equalsIgnoreCase("s") || response.equalsIgnoreCase("j"))) {
			System.out.println("Would you like to make a single account or a joint account? (s/j)");
			response = sc.nextLine();
		}
		if(response.equalsIgnoreCase("s")) {
			c.setAccountType("Single");
			//System.out.println("Your account type has been set to: " + c.getAccountType());
			System.out.println("How much balance would you like to deposit?");
			double answer = sc.nextDouble();
			setBalance(answer);
		} else { 
			c.setAccountType("Joint"); // implement createJointAccount()
			System.out.println("Your account type has been set to: " + c.getAccountType());
		} 
		c = new Customer(c.getUsername(), c.getPassword(), c.getAccountNumber(), c.getAccountType()); 
		
		System.out.println("You're all set! Thank you for submitting your application.");
		if(Employee.applicationStatus()) {
			System.out.println("Congratulations! Your application has been approved.");
			
			BankAccount b = new BankAccount(getBalance(), getAmount(), getAccountNumber());
			System.out.println("Here's your information: " + b.toString()); 
			Logging.LogIt("info", c.getUsername() + " was added");
		} else {
			System.out.println("Unfortunately, your application has been denied.");
		}
	}
	
	public void deposit() {
		System.out.println("How much would you like to deposit?");
		amount = sc.nextDouble();
		
		if(amount < 0) {
			System.out.println("Invalid amount!");
			return;
		}
		this.balance += amount;
		System.out.println("You have successfully deposited $" + amount + " into your account.");
		System.out.println("If you would like to view your total balance, please go back to the menu.");
		Logging.LogIt("info", c.getUsername() + " deposited $" + amount + " into their account.");
	}

	public void withdraw() {
		System.out.println("How much would you like to withdraw?");
		amount = sc.nextDouble();
		
		if(amount < 0) {
			System.out.println("Invalid amount!");
			return;
		} else if(amount > balance) {
			System.out.println("Unfortunately, you do not have enough balance in your account."); 
			return;
		} 
		this.balance -= amount;
		System.out.println("You have successfully withdrawn $" + amount + " from your account.");
		Logging.LogIt("info", c.getUsername() + " has withdrawn $" + getAmount() + " from their account.");
	}

	// Transfer ? Don't I have to ask or check if they have another account or is that assumed?
//	public void transfer() {
//		System.out.println("How much would you like to transfer?");
//		amount = sc.nextDouble();
//		
//		if(this.balance >= amount) {
//			this.balance -= amount;
//			b.balance += amount;
//			System.out.println("You have successfully transferred your funds.");
//			Logging.LogIt("info", c.getUsername() + " has transferred " + b.getAmount() + " into their account");
//		} else {
//			System.out.println("Something went wrong. Please try again.");
//			Menu.customerMenu();
//		}
//	}


}
