package com.revature.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.bank.BankAccount;
import com.revature.bank.Customer;
import com.revature.bank.Employee;
import com.revature.menu.Menu;

public class Database {
	public static List<Customer> customerList = new ArrayList<Customer>();
	public static List<BankAccount> accountList = new ArrayList<BankAccount>();
	
	public static Customer findCustomerByUsername(String input) {
		for(int i = 0; i < customerList.size(); i++) {
			String name = customerList.get(i).getUsername();
			if(input.equals(name)) {
				return customerList.get(i);
			}
		}
		System.out.println("Customer username not found");
		Menu.mainMenu();
		return null;
	}
	
	public static Customer findCustomerByPassword(String input) {
		for(int i = 0; i < customerList.size(); i++) {
			String password = customerList.get(i).getPassword();
			if(input.equals(password)) {
				return customerList.get(i);
			}
		}
		System.out.println("Customer password not found");
		Menu.mainMenu();
		return null;
	}
	
	public static Customer findCustomerByCustomerAccountNumber(int inputID) {
		for(int i = 0; i < customerList.size(); i++) {
			int accountID = customerList.get(i).getAccountNumber();
			if(accountID == inputID) { 
				return customerList.get(i);
			}
		}
		System.out.println("Customer account number not found");
		Menu.mainMenu();
		return null;
	}
	
	public static BankAccount findAccountByAccountNumber(int inputID) {
		for(int i = 0; i < accountList.size(); i++) {
			int accountNumber = accountList.get(i).getAccountNumber();
			if(accountNumber == inputID) {
				return accountList.get(i);
			}
		}
		System.out.println("Account number not found");
		Menu.mainMenu();
		return null;
	}
	
	public static Customer deleteCustomerByCustomerAccountID(int inputID) {
		for(int i = 0; i < customerList.size(); i++) {
			int accountID = customerList.get(i).getAccountNumber();
			if(accountID == inputID) { 
				return customerList.remove(i);
			}
		}
		System.out.println("Customer account ID not found. Account deletion failed.");
		Menu.mainMenu();
		return null;
	}
	
	public static BankAccount deleteAccountByAccountNumber(int inputID) {
		for(int i = 0; i < accountList.size(); i++) {
			int accountNumber = accountList.get(i).getAccountNumber();
			if(accountNumber == inputID) {
				return accountList.remove(i);
			}
		}
		System.out.println("Account number not found. Account deletion failed.");
		Menu.mainMenu();
		return null;
	}	
	
	public static int aFindHighestAccountNumber() {
		int highestNumber = 0;
		for(int i = 0; i < accountList.size(); i++) {
			int accountNumber = accountList.get(i).getAccountNumber();
			if(accountNumber > highestNumber) {
				highestNumber = accountNumber;
			}
		}
		highestNumber++;
		return highestNumber;
	}
	
	public static int cFindHighestAccountNumber() {
		int highestNumber = 0;
		for(int i = 0; i < customerList.size(); i++) {
			int accountNumber = customerList.get(i).getAccountNumber();
			if(accountNumber > highestNumber) {
				highestNumber = accountNumber;
			}
		}
		highestNumber++;
		return highestNumber;
	}
	
	public static void cprintAccountNumbers() {
		for(int i = 0; i < customerList.size(); i++) {
			int accountNumber = customerList.get(i).getAccountNumber();
			System.out.println("Account numbers of customerList: " + accountNumber);
		}
	}
	
	public static void aprintAccountNumbers() {
		for(int i = 0; i < accountList.size(); i++) {
			int accountNumber = accountList.get(i).getAccountNumber();
			System.out.println("Account numbers of accountList: " + accountNumber);
		}
	}
	
	public static void printList() {
		for(Customer c: customerList) {
			System.out.println("Customer List: " + c);
		}
		
		for(BankAccount c: accountList) {
			System.out.println("Account List: " + c);
		}
	}
}
