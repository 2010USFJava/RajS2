package com.revature.bank;

import java.util.Scanner;

import com.revature.menu.Menu;
import com.revature.record.RecordList;
import com.revature.util.Database;
import com.revature.util.Logging;

public class Employee {
	static Scanner sc = new Scanner(System.in);
	static RecordList r = new RecordList();
	
	// retrieve balance 
	public static void viewBalance() {
		System.out.println("Which customer's balance would you like to see? Please enter the customer's ID: ");
		int input = sc.nextInt();
		BankAccount.loadedAccount = Database.findAccountByAccountNumber(input);
		r.viewAccountInfo(BankAccount.loadedAccount);
		System.out.println("Current balance is: " + BankAccount.loadedAccount.getBalance());
	}
	
	// retrieve personal info: username, password, account type, account ID, balance
	public static void checkCustomerInfo() {
		System.out.println("Which customer's information would you like to see? Please enter the customer's ID: ");
		int inputID = sc.nextInt();
		BankAccount.loadedCustomer = Database.findCustomerByCustomerAccountNumber(inputID);
		r.viewCustomerInfo(BankAccount.loadedCustomer);
		BankAccount.loadedAccount = Database.findAccountByAccountNumber(inputID);
		r.viewAccountInfo(BankAccount.loadedAccount);
		System.out.println("\tUsername: " + BankAccount.loadedCustomer.getUsername() + "\n\tPassword: " + BankAccount.loadedCustomer.getPassword() + "\n\tAccount Type: " + BankAccount.loadedCustomer.getAccountType() 
		+ "\n\tAccount Number: " + BankAccount.loadedAccount.getAccountNumber() + "\n\tTotal balance: $" + BankAccount.loadedAccount.getBalance());
	}
	
	// approve/deny accounts
	public static boolean applicationStatus() {
		return true;	
	}
	
	//ADMIN ONLY!
	// cancel accounts
	public static void cancelAccount() {
		System.out.println("Enter the ID of the customer whose account you would like to delete: ");
		int inputID = sc.nextInt();
		sc.nextLine();
		System.out.println("The account will be permanently deleted. Are you sure you want to continue?(y/n)");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			Database.deleteCustomerByCustomerAccountID(inputID);
			Database.deleteAccountByAccountNumber(inputID);
			System.out.println("Your account has been deleted.");
			Logging.LogIt("info", "Deleted account");
		} else {
			System.out.println("Going back to menu...");
			Menu.employeeMenu();
		}
	}
	
}
