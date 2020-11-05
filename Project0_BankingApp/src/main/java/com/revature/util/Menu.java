package com.revature.util;

import java.util.Scanner;

import com.revature.bank.BankAccount;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	
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
				//apply to open account
				//openAccount();
				mainMenu();
				break;
			case "c":
				//login();
				customerMenu();
				break;
			case "e":
				//login();
				// employee menu: retrieve info, view balance, view account info
				employeeMenu();
				break;
			case "a":
				//login();
				// admin menu: delete account, approve/deny account, view user info
				adminMenu();
				break;
			case "q":
				System.out.println("Exiting the Banking App. Goodbye!");
			default:
				System.out.println("Invalid input. Please try again");
				mainMenu();
				break;
		}
		
	}
	
//	public static void login() {
//		String name;
//		System.out.println("Enter username: ");
//		name = sc.nextLine();
//		c.setUsername(name); // sets username of Customer
//		String word;
//		System.out.println("Enter password: ");
//		word = sc.nextLine();
//		c.setPassword(word); // sets password of Customer
//		
//	}
	
	static BankAccount myAccount = new BankAccount();
	
	public static void redirectToMainMenu() {
		System.out.println("Would you like to go back to the main menu?(y/n)");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			mainMenu();
		} else {
			System.out.println("Have a nice day! Goodbye.");		
		}
	}
	
	public static void customerMenu() {
		System.out.println("Welcome back!");
		System.out.println("What would you like to do?");
		System.out.println("\t[V]iew your balance");
		System.out.println("\t[M]ake a deposit");
		System.out.println("\t[W]ithdraw funds");
		System.out.println("\t[T]ransfer");
		System.out.println("\tPress any other key to go back to the main menu");
		
		String response = sc.nextLine();
		switch(response.toLowerCase()) {
			case "v":
				myAccount.getBalance();
				redirectToMainMenu();
				break;
			case "m":
				myAccount.deposit();
				redirectToMainMenu();
				break;
			case "w":
				myAccount.withdraw();
				redirectToMainMenu();
				break;
			case "t":
				myAccount.transfer();
				redirectToMainMenu();
				break;
			default:
				mainMenu();
				break;
		}

	}
	
	public static void employeeMenu() {
		
	}
	
	public static void adminMenu() {
		
	}
}
