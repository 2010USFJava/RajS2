package com.revature.bank;

import java.io.Serializable;

public class Customer extends BankAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 433026163531622217L;
	private String username;
	private String password;
	private int customerId;
	
	public Customer() {}

	public Customer(String username, String password, int customerId) {
		super();
		this.username = username;
		this.password = password;
		this.customerId = customerId;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public static int incrementCustomerId(int customerId) {
		return customerId++;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", customerId=" + customerId + "]";
	}

}
