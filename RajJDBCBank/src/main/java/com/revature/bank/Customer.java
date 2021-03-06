package com.revature.bank;

import com.revature.util.Log;

public class Customer {
	private int userID;
	private String firstName;
	private String lastName;
	private String username;
	private String password;

	public Customer() {
		super();
		Log.LogIt("info", "An empty customer was added");
	}
	
	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Customer(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	public Customer(int userID, String firstName, String lastName, String username, String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
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

	public int getuserID() {
		return userID;
	}

	public void setuserID(int userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "Customer -> userID: " + userID + " | firstName: " + firstName + " | lastName: " + lastName + " | username: "
				+ username + " | password: " + password + "";
	}

}
