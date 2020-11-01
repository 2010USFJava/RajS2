package com.revature.bank;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		System.out.println("Welcome to the Banking App!");
		System.out.println("Please choose one of the following options. Are you a:");
		System.out.println("\n\t[n]ew customer");
		System.out.println("\n\t[c]urrent customer");
		System.out.println("\n\t[e]mployee");
		System.out.println("\n\t[a]dmin");
		
		String option = sc.nextLine();
		
		switch(option.toLowerCase()) {
			case "n":
				//apply to open account
				//openAccount();
				menu();
				break;
			case "c":
				// login
				// customer menu - what would you like to do: withdraw, transfer, deposit, view balance
				break;
			case "e":
				// login
				// employee menu: retrieve info, view balance, view account info
				break;
			case "a":
				// login
				// admin menu: delete account, approve/deny account, view user info
				break;
			case "q":
				System.out.println("Exiting the Banking App. Goodbye!");
			default:
				System.out.println("Invalid input. Please try again");
				menu();
				break;
		}
		
	}
	
}
