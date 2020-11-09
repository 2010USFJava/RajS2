package com.revature.bank;

import java.util.Scanner;

import com.revature.util.Database;

public class SignIn {
	static Scanner sc = new Scanner(System.in);
	
	public static void customerLogin() {
		System.out.println("Enter username: ");
		String inputName = sc.nextLine();
		System.out.println("Enter password: ");
		String inputWord = sc.nextLine();
		Customer a = Database.findCustomerByUsername(inputName);
		Customer b = Database.findCustomerByPassword(inputWord);
		if(a.equals(b)) {
			System.out.println("Successfully logged in");
			BankAccount.loadedAccount = Database.findAccountByAccountNumber(a.getAccountNumber());
			BankAccount.loadedCustomer = Database.findCustomerByCustomerAccountNumber(a.getAccountNumber());
		} else {
			System.out.println("Invalid username or password.");
		}		
	}
}
