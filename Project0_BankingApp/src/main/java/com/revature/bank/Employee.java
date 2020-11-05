package com.revature.bank;

public class Employee {
	private String username;
	private String password;
	private int employeeID;
	private BankAccount account;
	
	public Employee() {
		super();
	}

	public Employee(String username, String password, int employeeID, BankAccount account) {
		super();
		this.username = username;
		this.password = password;
		this.employeeID = employeeID;
		this.account = account;
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

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", employeeID=" + employeeID + ", account="
				+ account + "]";
	}
	
	// retrieve balance
	
	// retrieve personal info

	
}
