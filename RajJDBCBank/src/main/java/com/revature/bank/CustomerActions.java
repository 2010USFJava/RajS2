package com.revature.bank;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.menu.Menu;

public class CustomerActions {
	static Scanner sc = new Scanner(System.in);
	public static final int LENGTH = 5;
	
	public static boolean validate(String input) { 
		if (input.length() < LENGTH) {
			System.out.println("Invalid! Please try again.");
			return false;
		}
		int numberOfNums = 0, numberOfCh = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				numberOfNums++;
			} else if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z'
					|| input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
				numberOfCh++;
			} else {
				return false;
			}
		}
		if (numberOfNums > 0 && numberOfCh > 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isOnlyLetters(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z' || input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
			} else {
				return false;
			}
		}
		return true;
	}

	public static void openAccount() {	
		String firstName, lastName;
		do {
			System.out.println("Enter first name: ");
			firstName = sc.nextLine();
		} while (!isOnlyLetters(firstName));
		
		do {
			System.out.println("Enter last name: "); 
			lastName = sc.nextLine();
		} while (!isOnlyLetters(lastName));
		
		String username, password;
		do {
			System.out.println("Enter username (Must be at least " + LENGTH
					+ " characters long and consist of both letters & numbers): ");
			username = sc.nextLine();
		} while (!validate(username));
		System.out.println("Username is valid.");

		do {
			System.out.println("Enter password (Must be at least " + LENGTH
					+ " characters long and consist of both letters & numbers):");
			password = sc.nextLine();
			if (username.equals(password)) {
				System.out.println("Password cannot be the same as username. Please try again.");
				System.out.println(
						"Enter password (Must be at least 7 characters long and consist of both letters & numbers only):");
				password = sc.nextLine();
			}
		} while (!validate(password));
		System.out.println("Password is valid.");		
		
		// first time deposit
		System.out.println();
		System.out.println("Enter first time deposit amount: ");
		double deposit = sc.nextDouble();
		sc.nextLine();
		
		//account type
		System.out.println("Would you like to make a checking account or a savings account? (c/s)");
		String type = sc.nextLine();
		while(!(type.equalsIgnoreCase("c") || type.equalsIgnoreCase("s"))) {
			System.out.println("Would you like to make a checking account or a savings account? (c/s)");
			type = sc.nextLine();
		}
		if(type.equalsIgnoreCase("c")) {
			type = "Checking";
		} else { 
			type = "Savings";			
		} 
		
		try {
			Menu.b.createBankAccount(new BankAccount(deposit, type));
			Menu.c.createNewCustomer(new Customer(firstName, lastName, username, password));
			System.out.println("Congratulations! The account is approved.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
