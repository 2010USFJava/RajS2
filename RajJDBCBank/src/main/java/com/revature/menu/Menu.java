package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bank.AdminActions;
import com.revature.bank.BankAccount;
import com.revature.bank.Customer;
import com.revature.bank.CustomerActions;
import com.revature.bank.Login;
import com.revature.dao.AdminDao;
import com.revature.dao.BankAccountDao;
import com.revature.dao.CustomerDao;
import com.revature.daoimpl.AdminDaoImpl;
import com.revature.daoimpl.BankAccountDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.util.Log;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	public static BankAccountDao b = new BankAccountDaoImpl();
	public static CustomerDao c = new CustomerDaoImpl();
	
	public static void mainMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("         Welcome to RajJDBC Bank!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Please choose one of the following options:");
		System.out.println("\t[R]egister");
		System.out.println("\t[C]ustomer login");
		System.out.println("\t[A]dmin login");
		System.out.println("\t[Q]uit");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		String response = sc.nextLine();
		
		switch(response.toLowerCase()) {
			case "r":
				CustomerActions.openAccount();
				mainMenu();
				break;
			case "c":
				Login.customerLoginInput();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("        	    Welcome!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				customerMenu();
				break;
			case "a":
				Login.adminLogin();
				adminMenu();
				break;
			case "q":
				System.out.println("Exiting RajJDBC Bank. Goodbye!");
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				mainMenu();
				break;
		}
		
	}
	
	public static void customerMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("What would you like to do?");
		System.out.println("\t[V]iew your existing accounts & balances");
		System.out.println("\t[M]ake deposit");
		System.out.println("\t[W]ithdraw funds");
		System.out.println("\t[D]elete account");
		System.out.println("\t[L]ogout");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		String response = sc.nextLine();
		switch(response.toLowerCase()) {
			case "v":
				try {
					c.findCustomerById(BankAccountDaoImpl.currentBankID);
					b.findAccountById(BankAccountDaoImpl.currentBankID); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
				customerMenu();
				break;
			case "m":
				try {
					b.deposit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				customerMenu();
				break;
			case "w":
				try {
					b.withdraw();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				customerMenu();
				break;
			case "d":
				try {
					b.deleteIfEmpty();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				customerMenu();
				break;
			case "l":
				System.out.println("You have successfully logged off. \nHave a great day! Goodbye!\n");
				Log.LogIt("info", "Customer with account ID, " + BankAccountDaoImpl.currentBankID + ", has logged out.");
				System.out.println();
				mainMenu();
				break;
			default:
				mainMenu();
				break;
		}

	}
		
	public static void adminMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("           Welcome Admin!     ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("What would you like to do?");
		System.out.println("\t[O]pen new customer account");
		System.out.println("\t[C]hecking (number of this type)");
		System.out.println("\t[S]avings (number of this type)");
		System.out.println("\t[V]iew all customer accounts");
		System.out.println("\t[I]ndividual customer account"); 
		System.out.println("\t[U]pdate customer account");
		System.out.println("\t[D]elete customer account");
		System.out.println("\t[L]ogout");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		String response = sc.nextLine();
		switch(response.toLowerCase()) {
			case "o":
				CustomerActions.openAccount();
				adminMenu();
				break;
			case "c":
			try {
				System.out.println("Number of checking account types in RajJDBC Bank: " + b.numOfTypeChecking());
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				adminMenu();
				break;
			case "s":
			try {
				System.out.println("Number of savings account types in RajJDBC Bank: " + b.numOfTypeSavings());
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				adminMenu();
				break;
			case "v":
				AdminActions.viewAll();
				adminMenu();
				break;
			case "i":
				AdminActions.viewCustomerInfo();
				adminMenu();
				break;
			case "u":
				AdminActions.updateCustomerInfo();
				adminMenu();
				break;
			case "d":
				AdminActions.deleteAccount();
				adminMenu();
				break;
			case "l":
				System.out.println("You have successfully logged off. \\nHave a great day! Goodbye!\n");
				Log.LogIt("info", "Admin has logged out.");
				System.out.println();
				mainMenu();
				break;
			default:
				mainMenu();
				break;
		}
	}
	
	public static Customer updateCustomerInfoMenu(Customer c) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Which of the following would you like to change?");
		System.out.println("\t[F]irst name");
		System.out.println("\t[L]ast name");
		System.out.println("\t[U]sername");
		System.out.println("\t[P]assword");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String response = sc.nextLine();
		String newResponse;
		switch(response.toLowerCase()) {
			case "f":
				System.out.println("Enter new first name: ");
				newResponse = sc.nextLine();
				c.setFirstName(newResponse);
				Log.LogIt("info", "Updated first name of customer with account ID, " + BankAccountDaoImpl.currentBankID + ", to: " + newResponse);
				break;
			case "l":
				System.out.println("Enter new last name: ");
				newResponse = sc.nextLine();
				c.setLastName(newResponse);
				Log.LogIt("info", "Updated last name of customer with account ID, " + BankAccountDaoImpl.currentBankID + ", to: " + newResponse);
				break;
			case "u":
				System.out.println("Enter new username: ");
				newResponse = sc.nextLine();
				c.setUsername(newResponse);
				Log.LogIt("info", "Updated username of customer with account ID, " + BankAccountDaoImpl.currentBankID + ", to: " + newResponse);
				break;
			case "p":
				System.out.println("Enter new password: ");
				newResponse = sc.nextLine();
				c.setPassword(newResponse);
				Log.LogIt("info", "Updated password of customer with account ID, " + BankAccountDaoImpl.currentBankID + ", to: " + newResponse);
				break;
			default:
				System.out.println("Invalid input. Please try again");
				adminMenu();
				break;
				
		}
		return c;	
	}
	
	public static BankAccount updateAccountInfoMenu(BankAccount b) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Which of the following would you like to change?");
		System.out.println("\t[A]ccount type");
		System.out.println("\t[B]alance");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		String response = sc.nextLine();
		switch(response.toLowerCase()) {
			case "a":
				System.out.println("Enter new account type: ");
				String newResponse = sc.nextLine();
				b.setAccountType(newResponse);
				Log.LogIt("info", "Updated account type of account with account ID, " + BankAccountDaoImpl.currentBankID + ", to: " + newResponse);
				break;
			case "b":
				System.out.println("Enter new balance: ");
				double newValue = sc.nextDouble();
				sc.nextLine();
				b.setBalance(newValue);
				Log.LogIt("info", "Updated balance of account with account ID, " + BankAccountDaoImpl.currentBankID + ", to: " + newValue);
				break;
			default:
				System.out.println("Invalid input. Please try again");
				adminMenu();
				break;
		}
		return b;
	}
}
