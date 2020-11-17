package com.revature.bank;

import java.util.Scanner;

public class BankActions {
	static Scanner sc = new Scanner(System.in);

	public static double calculateDeposit(double balance) {
		double amount = 0;
		System.out.println("How much would you like to deposit?");
		amount = sc.nextDouble();

		while(amount < 0) {
			System.out.println("Invalid amount! Please try again.\n");
			System.out.println("How much would you like to deposit?");
			amount = sc.nextDouble();
		}
		balance += amount;
		return balance;
	}

	public static double calculateWithdraw(double balance) {
		double amount = 0;
		System.out.println("How much would you like to withdraw?");
		amount = sc.nextDouble();

		while(amount < 0 || amount > balance) {
			System.out.println("Invalid amount! Please try again.\n");
			System.out.println("How much would you like to withdraw?");
			amount = sc.nextDouble();
		}
		balance -= amount;
		return balance;		
	}

}
