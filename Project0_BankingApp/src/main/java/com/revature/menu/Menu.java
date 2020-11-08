package com.revature.menu;

import java.util.Scanner;

import com.revature.bank.BankAccount;
import com.revature.bank.Employee;
import com.revature.bank.SignIn;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	
	static BankAccount myAccount = new BankAccount();
	static String user;
	static String userC = "Customer";
	static String userE = "Employee";
	static String userA = "Admin";
	
	public static void mainMenu() {
		System.out.println("Welcome to the Banking App!");
		System.out.println("Please choose one of the following options. Are you a:");
		System.out.println("\t[N]ew customer");
		System.out.println("\t[C]urrent customer");
		System.out.println("\t[E]mployee");
		System.out.println("\t[A]dmin");
		
		String response = sc.nextLine();
		
		switch(response.toLowerCase()) {
			case "n":
				myAccount.openAccount();
				mainMenu();
				break;
			case "c":
				user = "Customer";
				SignIn.customerLogin();
				customerMenu();
				break;
			case "e":
				user = "Employee";
				//SignIn.employeeLogin();
				employeeMenu();
				break;
			case "a":
				user = "Admin";
				//SignIn.employeeLogin();
				employeeMenu();
				break;
			case "q":
				System.out.println("Exiting the Banking App. Goodbye!");
				break;
			default:
				System.out.println("Invalid input. Please try again");
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
			else if(user.equals(userE) || user.equals(userA)) {
				employeeMenu();
			} else {
				System.out.println("Going back to main menu");
				mainMenu();
			}
		} else {
			System.out.println("Have a wonderful day! Goodbye.");		
		}
	}
	
	public static void customerMenu() {
		System.out.println("Welcome!");
		System.out.println("What would you like to do?");
		System.out.println("\t[V]iew your balance");
		System.out.println("\t[M]ake a deposit");
		System.out.println("\t[W]ithdraw funds");
		System.out.println("\t[T]ransfer funds");
		System.out.println("\t[Q]uit");
		System.out.println("\tPress any other key to go back to the main menu");
		
		String response = sc.nextLine();
		switch(response.toLowerCase()) {
			case "v":
				System.out.println("Balance: " + myAccount.getBalance());
				redirectToMenu();
				break;
			case "m":
				myAccount.deposit();
				redirectToMenu();
				break;
			case "w":
				myAccount.withdraw();
				redirectToMenu();
				break;
			case "t":
				//myAccount.transfer();
				redirectToMenu();
				break;
			case "q":
				System.out.println("Have a wonderful day! Goodbye!");
				break;
			default:
				mainMenu();
				break;
		}

	}
		
	public static void employeeMenu() {
		System.out.println("Welcome!");
		System.out.println("What would you like to do?");
		System.out.println("\t[V]iew customer balance");
		System.out.println("\t[C]heck customer's personal information");
		System.out.println("\t[A]pplication approval status");
		System.out.println("\t[D]elete customer account [ADMINS ONLY]");
		System.out.println("\tPress any other key to go back to the main menu");
		
		String response = sc.nextLine();
		switch(response.toLowerCase()) {
			case "v":
				Employee.viewBalance();
				redirectToMenu();
				break;
			case "c":
				Employee.checkCustomerInfo();
				redirectToMenu();
				break;
			case "a":
				Employee.applicationStatus();
				redirectToMenu();
				break;
			case "d":
				if(user.equals(userE)) {
					System.out.println("Restricted access. ADMINS ONLY!");
					redirectToMenu();
					break;
				}
				Employee.cancelAccount();
				redirectToMenu();
				break;
			default:
				mainMenu();
				break;
		}
	}
}
