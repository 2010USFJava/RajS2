package com.revature.bank;

import com.revature.util.Log;

public class BankAccount {
	private int accountNumber;
	private double balance;
	private String accountType;
	
	public BankAccount() {
		super();
		Log.LogIt("info", "An empty account was added");
	}
	
	public BankAccount(double balance, String accountType) {
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public BankAccount(int accountNumber, double balance, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "BankAccount -> accountNumber: " + accountNumber + " | balance: " + balance + " | accountType: " + accountType
				+ "";
	}
}
