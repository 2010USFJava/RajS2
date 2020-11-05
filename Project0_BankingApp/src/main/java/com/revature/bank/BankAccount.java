package com.revature.bank;

import java.util.Scanner;

public class BankAccount {
	private double balance;
	private double amount;
	private BankAccount otherAccount;
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

	Scanner sc = new Scanner(System.in);
	
	// Open account
	public void openAccount() {

	}
	
	// Deposit
	public void deposit() {
		System.out.println("How much would you like to deposit?");
		amount = sc.nextDouble();
		
		if (amount < 0) {
			System.out.println("Invalid amount!");
			return;
		}
		this.balance += amount;
		System.out.println("You have successfully deposited $" + amount + " into your account.");
		System.out.println("If you would like to view your total balance, please go back to the main menu.");
	}

	// Withdraw
	public void withdraw() {
		System.out.println("How much would you like to withdraw?");
		amount = sc.nextDouble();
		
		if (amount < 0) {
			System.out.println("Invalid amount!");
			return;
		} else if (amount > balance) {
			System.out.println("Unfortunately, you do not have enough balance in your account."); 
			return;
		} 
		this.balance -= amount;
		System.out.println("You have successfully withdrawn $" + amount + " from your account.");
	}

	// Transfer
	public void transfer() {
//		System.out.println("How much would you like to transfer?");
//		amount = sc.nextDouble();
//		
//		if (this.balance >= amount) {
//			this.balance -= amount;
//			otherAccount.balance += amount;
//			System.out.println("You have successfully transferred your funds.");
//		} else {
//			System.out.println("Something went wrong. Please try again.");
//		}
		return;
	}


}
