package com.revature.bank;

import com.revature.util.Log;

public class Admin {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int adminID;
	
	public Admin() {
		super();
		Log.LogIt("info", "An empty admin was added");
	}
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Admin(int adminID, String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.adminID = adminID;
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
	
	public int getAdminID() {
		return adminID;
	}
	
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	@Override
	public String toString() {
		return "Admin -> firstName=" + firstName + " | lastName=" + lastName + " | username=" + username + " | password="
				+ password + " | adminID=" + adminID + "";
	}
}
