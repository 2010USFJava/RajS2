package com.revature.menu;

import java.util.Scanner;

//import com.revature.bank.BankAccount;
//import com.revature.bank.Employee;
//import com.revature.bank.SignIn;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static String user;
	static String userC = "Customer";
	static String userA = "Admin";
	
	public static void mainMenu() {
		System.out.println("Welcome to RajJDBC Bank!");
		System.out.println("Please choose one of the following options:");
		System.out.println("\t[R]egister");
		System.out.println("\t[C]ustomer login");
		System.out.println("\t[A]dmin login");
		System.out.println("\t[Q]uit"); //maybe?
		
		String response = sc.nextLine();
		
		switch(response.toLowerCase()) {
			case "r":
				//BankAccount.myAccount.openAccount();
				mainMenu();
				break;
			case "c":
				user = "Customer";
				//SignIn.customerLogin();
				customerMenu();
				break;
			case "a":
				user = "Admin";
				adminMenu();
				break;
			case "q":
				System.out.println("Exiting Rev Bank. Goodbye!");
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				mainMenu();
				break;
		}
		
	}
	
	public static void redirectToMenu() {
		System.out.println("Would you like to go back to the menu?(y/n)");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			if(user.equals(userC)) {
				customerMenu();
			}
			else if(user.equals(userA)) {
				adminMenu();
			} else {
				System.out.println("Going back to main menu...");
				mainMenu();
			}
		} else {
			System.out.println("Have a wonderful day! Goodbye.");		
		}
	}
	
	public static void customerMenu() {
		System.out.println("Welcome!"); //get name of customer
		System.out.println("What would you like to do?");
		System.out.println("\t[V]iew your existing accounts & balances");
		System.out.println("\t[D]eposit");
		System.out.println("\t[W]ithdraw funds");
		System.out.println("\t[L]ogout");
		System.out.println("\tPress any other key to go back to the main menu");
		
		String response = sc.nextLine();
		switch(response.toLowerCase()) {
			case "v":
				//System.out.println("Balance: " + BankAccount.loadedAccount.getBalance());
				redirectToMenu();
				break;
			case "d":
				//BankAccount.loadedAccount.deposit();
				System.out.println("Would you like to make another deposit? (y/n)");
				response = sc.nextLine();
				if(response.equalsIgnoreCase("y")) {
					// call deposit method
				} else {
					redirectToMenu();
				}
				break;
			case "w":
				//BankAccount.loadedAccount.withdraw();
				System.out.println("Would you like to make another withdrawal? (y/n)");
				response = sc.nextLine();
				if(response.equalsIgnoreCase("y")) {
					// call withdraw method
				} else {
					redirectToMenu();
				}
				break;
			case "l":
				System.out.println("You have successfully logged off. \nHave a great day! Goodbye!");
				break;
			default:
				mainMenu();
				break;
		}

	}
		
	public static void adminMenu() {
		System.out.println("Welcome Admin!");
		System.out.println("What would you like to do?");
		System.out.println("\t[C]reate customer account");
		System.out.println("\t[V]iew customer account");
		System.out.println("\t[U]pdate customer account");
		System.out.println("\t[D]elete customer account");
		System.out.println("\t[L]ogout");
		System.out.println("\tPress any other key to go back to the main menu");
		
		String response = sc.nextLine();
		switch(response.toLowerCase()) {
			case "c":
				//Employee.checkCustomerInfo();
				redirectToMenu();
				break;
			case "v":
				//Employee.viewBalance();
				redirectToMenu();
				break;
			case "u":
				break;
			case "d":
				//Employee.cancelAccount();
				redirectToMenu();
				break;
			case "l":
				System.out.println("You have successfully logged off. \\nHave a great day! Goodbye!");
				break;
			default:
				mainMenu();
				break;
		}
	}
}
