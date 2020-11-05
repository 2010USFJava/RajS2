package com.revature.bank;

public class Customer {
	private String username;
	private String password;
	private int customerID;
	
	public Customer() {}

	public Customer(String username, String password, int customerID) {
		super();
		this.username = username;
		this.password = password;
		this.customerID = customerID;
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

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerIdD(int customerID) {
		this.customerID = customerID;
	}
	
	public static int incrementCustomerID(int customerID) {
		return customerID++;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", customerID=" + customerID + "]";
	}

}
