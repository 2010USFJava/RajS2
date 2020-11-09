package com.revature.bank;

import java.io.Serializable;

import com.revature.util.FileIO;
import com.revature.util.Logging;
import com.revature.util.Database;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1031730799528113995L;
	private String username;
	private String password;
	private static int accountNumber = 1000;
	private String accountType; //single or joint account
	
	public Customer() {
		super();
		Database.customerList.add(this);
		Logging.LogIt("info", "An empty customer was added");
	}

	public Customer(String username, String password, int accountNumber, String accountType) {
		super();
		this.username = username;
		this.password = password;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		Database.customerList.add(this);
		FileIO.writeCustomerFile(Database.customerList);
		Logging.LogIt("info", "A customer was added");
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", accountNumber=" + accountNumber
				+ ", accountType=" + accountType + "]";
	}
	
}
