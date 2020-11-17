package com.revature.bank;

import java.util.Scanner;

public class BankActions {
	static Scanner sc = new Scanner(System.in);
	
	public static double getAmountDeposit() {
		double amount = 0;
		System.out.println("How much would you like to deposit?");
		amount = sc.nextDouble();
		return amount;
	}

	public static double calculateDeposit(double balance) {
		double amount = getAmountDeposit();
		while(amount < 0) {
			System.out.println("Invalid amount! Please try again.\n");
			System.out.println("How much would you like to deposit?");
			amount = sc.nextDouble();
		}
		balance += amount;
		return balance;
	}
	
	public static double getAmountWithdraw() {
		double amount = 0;
		System.out.println("How much would you like to withdraw?");
		amount = sc.nextDouble();
		return amount;
	}

	public static double calculateWithdraw(double balance) {
		double amount = getAmountWithdraw();

		while(amount < 0 || amount > balance) {
			System.out.println("Invalid amount! Please try again.\n");
			System.out.println("How much would you like to withdraw?");
			amount = sc.nextDouble();
		}
		balance -= amount;
		return balance;		
	}

}
