package com.revature.bank;

import java.util.Scanner;

import com.revature.util.Database;

public class SignIn {
	static Scanner sc = new Scanner(System.in);
	
	public static void customerLogin() {
		Customer c = new Customer();
		System.out.println("Enter username: ");
		String inputName = sc.nextLine();
		System.out.println("Enter password: ");
		String inputWord = sc.nextLine();
		if(Database.findCustomerByUsername(inputName).equals(c.getUsername()) == Database.findCustomerByPassword(inputWord).equals(c.getPassword())) {
			System.out.println("Successfully logged in");
		} else {
			System.out.println("Invalid username or password.");
		}		
	}
	
	// login for both employee and admin
	public static void employeeLogin() {
		System.out.println("Enter username: ");
		String inputName = sc.nextLine();
		System.out.println("Enter password: ");
		String inputWord = sc.nextLine();
		
		//Database.employeeList.add(); 
	}

}
