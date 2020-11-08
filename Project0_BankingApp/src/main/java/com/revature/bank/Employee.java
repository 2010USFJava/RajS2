package com.revature.bank;

import java.util.Scanner;

import com.revature.menu.Menu;
import com.revature.record.RecordList;
import com.revature.util.Database;
import com.revature.util.Logging;

public class Employee {
	private String username;
	private String password;
	private BankAccount account; //?
	
	public Employee() {
		super();
	}

	public Employee(String username, String password, BankAccount account) {
		super();
		this.username = username;
		this.password = password;
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

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", account="
				+ account + "]";
	}
	
	static Scanner sc = new Scanner(System.in);
	static RecordList r = new RecordList();
	
	// retrieve balance 
	public static void viewBalance() {
		System.out.println("Which customer's balance would you like to see? Please enter the customer's ID: ");
		int input = sc.nextInt();
		BankAccount b = Database.findAccountByAccountNumber(input);
		r.viewAccountInfo(b);
		System.out.println("Current balance is: " + b.getBalance());
	}
	
	// retrieve personal info: username, password, account type, account ID, balance
	public static void checkCustomerInfo() {
		System.out.println("Which customer's information would you like to see? Please enter the customer's ID: ");
		int inputID = sc.nextInt();
		Customer c = Database.findCustomerByCustomerAccountID(inputID);
		r.viewCustomerInfo(c);
		BankAccount b = Database.findAccountByAccountNumber(inputID);
		r.viewAccountInfo(b);
		System.out.println("\tUsername: " + c.getUsername() + "\n\tPassword: " + c.getPassword() + "\n\tAccount Type: " + c.getAccountType() 
		+ "\n\tAccount Number: " + b.getAccountNumber() + "\n\tTotal balance: $" + b.getBalance());
	}
	
	// approve/deny accounts
	public static boolean applicationStatus() {
		//Logging.LogIt("info", "Application has been approved");
		return true;	
	}
	
	//ADMIN ONLY!
	// cancel accounts
	public static void cancelAccount() {
		System.out.println("Enter the ID of the customer whose account you would like to delete: ");
		int inputID = Integer.parseInt(sc.nextLine());
		System.out.println("The account will be permanently deleted. Are you sure you want to continue?(y/n)");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			Database.deleteCustomerByCustomerAccountID(inputID);
			Database.deleteAccountByAccountNumber(inputID);
		} else {
			System.out.println("Going back to menu...");
			Menu.employeeMenu();
		}
		//Logging.LogIt("info", "Account has been deleted");
	}
	
}
