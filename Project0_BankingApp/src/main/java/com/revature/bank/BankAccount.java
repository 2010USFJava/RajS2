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
	transient static Scanner sc = new Scanner(System.in);
	public static BankAccount myAccount = new BankAccount();
	public static BankAccount loadedAccount;
	public static Customer c = new Customer();
	public static Customer loadedCustomer;
	public static final int LENGTH = 5;
	
	public BankAccount() {
		super();
		Database.accountList.add(this);
		Logging.LogIt("info", "An empty account has been added");
	}
	
	public BankAccount(double balance, double amount, int accountNumber) {
		super();
		this.balance = balance;
		this.amount = amount;
		this.accountNumber = accountNumber;
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
	
	public boolean validate(String input) { 
		if(input.length() < LENGTH) { 
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
		if(numberOfNums > 0 && numberOfCh > 0) {
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
		} else { 
			c.setAccountType("Joint");				
		} 
		System.out.println("You're all set! Thank you for submitting your application.");

		
		if(Employee.applicationStatus()) { 
			System.out.println("Congratulations! Your application has been approved.");	
			
			if(c.getAccountType().equals("Single")) {
				System.out.println("What amount would you like to add for your first time deposit?");
				double answer = sc.nextDouble();
				//sc.nextLine();
				setBalance(answer);
			}

			int cHighestAccountNumber = Database.cFindHighestAccountNumber();
			c.setAccountNumber(cHighestAccountNumber);
			Customer addedCustomer = new Customer(c.getUsername(), c.getPassword(), c.getAccountNumber(), c.getAccountType()); 
			
			int aHighestAccountNumber = Database.aFindHighestAccountNumber();
			setAccountNumber(aHighestAccountNumber);
			
			if(c.getAccountType().equals("Joint")) {
				System.out.println("Which current customer would you like to join? Enter their username: ");
				String name = sc.nextLine();
				int sameAccountNumber = Database.findCustomerByUsername(name).getAccountNumber();
				setAccountNumber(sameAccountNumber);
				setBalance(Database.findAccountByAccountNumber(sameAccountNumber).getBalance());
			}
			
			myAccount = new BankAccount(getBalance(), getAmount(), getAccountNumber());
			
			System.out.println("Here's your information: " + myAccount + "\n" + addedCustomer.toString()); 
			FileIO.writeAccountFile(Database.accountList);
			Logging.LogIt("info", addedCustomer.getUsername() + " was added");
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
		loadedAccount.setBalance(balance+amount);
		System.out.println("You have successfully deposited $" + amount + " into your account.");
		System.out.println("If you would like to view your total balance, please go back to the menu.");
		FileIO.writeAccountFile(Database.accountList);
		Logging.LogIt("info", loadedCustomer.getUsername() + " deposited $" + loadedAccount.getAmount() + " into their account.");
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
		loadedAccount.setBalance(balance-amount);
		System.out.println("You have successfully withdrawn $" + amount + " from your account.");
		FileIO.writeAccountFile(Database.accountList);
		Logging.LogIt("info", loadedCustomer.getUsername() + " has withdrawn $" + loadedAccount.getAmount() + " from their account.");
	}

	// Transfer XX
	public void transfer() {
		System.out.println("What is the account number you would like to transfer to?");
		int accountNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("How much would you like to transfer?");
		amount = sc.nextDouble();
		
		if(balance >= amount) {
			loadedAccount.setBalance(balance-amount);
			double balanceOfTransferCustomer = Database.findAccountByAccountNumber(accountNumber).getBalance();
			//Database.findAccountByAccountNumber(accountNumber).setBalance(balanceOfTransferCustomer+amount);
			System.out.println("You have successfully transferred your funds.");
			FileIO.writeAccountFile(Database.accountList);
			Logging.LogIt("info", loadedCustomer.getUsername() + " has transferred $" + loadedAccount.getAmount());
		} else {
			System.out.println("Something went wrong. Please try again.");
			Menu.customerMenu();
		}
	}


}
