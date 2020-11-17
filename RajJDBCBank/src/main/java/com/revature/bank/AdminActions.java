package com.revature.bank;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.AdminDao;
import com.revature.daoimpl.AdminDaoImpl;
import com.revature.daoimpl.BankAccountDaoImpl;
import com.revature.menu.Menu;
import com.revature.util.Log;

public class AdminActions {
	static Scanner sc = new Scanner(System.in);
	static AdminDao a = new AdminDaoImpl();
	
	// retrieve personal info: first name, last name, username, password, account type, account number, balance
	public static void viewCustomerInfo() {
		System.out.println("Which customer's information would you like to see? Please enter the customer's account number: ");
		int inputID = sc.nextInt();
		try {
			Menu.c.findCustomerById(inputID);
			Menu.b.findAccountById(inputID);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void viewAll() {
		try {
			for(Customer c : Menu.c.viewAllCustomers()) {
				System.out.println(c);
			}
			for(BankAccount b: Menu.b.viewAllAccounts()) {
				System.out.println(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCustomerInfo() {
		System.out.println("Which customer's information would you like to update? Please enter the customer's account number: ");
		int inputID = sc.nextInt();
		sc.nextLine();
		BankAccountDaoImpl.currentBankID = inputID;
		
		System.out.println("Do you want to change customer's personal information or their bankaccount information?(c/b)");
		String response = sc.nextLine();
		
			try {
				if (response.equalsIgnoreCase("c")) {
					Customer updateC = Menu.c.findCustomerById(BankAccountDaoImpl.currentBankID);
					a.editAllCustomerInfo(updateC);
				} else {
					BankAccount updateB = Menu.b.findAccountById(BankAccountDaoImpl.currentBankID);
					a.editAllAccountInfo(updateB);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// delete accounts
	public static void deleteAccount() {
		System.out.println("Enter the account number of the customer whose account you would like to delete: ");
		int inputID = sc.nextInt();
		sc.nextLine();
		System.out.println();
		System.out.println("This account will be permanently deleted. Are you sure you want to continue?(y/n)");
		String answer = sc.nextLine();
		if (answer.equalsIgnoreCase("y")) {
			try {
				Menu.b.deleteAccount(inputID);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Log.LogIt("info", "Deleted account with account number, " + inputID);
		} else {
			System.out.println("Going back to menu...");
			Menu.adminMenu();
		}
	}
}
