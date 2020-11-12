package com.revature.bank;

import com.revature.util.Log;

public class Customer {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int accountNumber;

	public Customer() {
		super();
		Log.LogIt("info", "An empty customer was added");
	}

	public Customer(String firstName, String lastName, String username, String password, int accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.accountNumber = accountNumber;
		Log.LogIt("info", "Customer, " + getFirstName() + " " + getLastName() + ", was added");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", accountNumber=" + accountNumber + "]";
	}

}
