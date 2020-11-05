package com.revature.bank;

public class Admin {
	private String username;
	private String password;
	private int adminID;
	private BankAccount account;
	
	public Admin() {
		super();
	}

	public Admin(String username, String password, int adminID, BankAccount account) {
		super();
		this.username = username;
		this.password = password;
		this.adminID = adminID;
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

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", adminID=" + adminID + ", account="
				+ account + "]";
	}	
	
	// retrieve balance
	
	// retrieve personal info
	
	// cancel accounts
	
	// approve/deny accounts
}
