package com.revature.bank;

import java.util.Scanner;

public class BankAccount {
	private double balance;
	private double amount;
	//private int NUM_OF_ACCOUNTS = 2;
	
	public BankAccount() {}
	
	public BankAccount(double balance, double amount) {
		super();
		this.balance = balance;
		this.amount = amount;
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

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + ", amount=" + amount + "]";
	}

	
	public static Scanner sc = new Scanner(System.in);
	// Open account
	public void openAccount(Customer c, double balance) {
		// give username and password, set balance, type
		//using scanner ask customer to enter username and password
		String name;
		System.out.println("Enter username: ");
		name = sc.nextLine();
		c.setUsername(name); // sets username of Customer
		String word;
		System.out.println("Enter password: ");
		word = sc.nextLine();
		c.setPassword(word); // sets password of Customer
		
	}

	// Deposit
	public void deposit(double amount) {
		if (amount < 0) {
			System.out.println("Invalid amount!");
		}
		this.balance += amount;
	}

	// Withdraw
	public boolean withdraw(double amount) {

	}

	// Transfer
	public boolean transfer(BankAccount otherAccount, double amount) {

	}


}
