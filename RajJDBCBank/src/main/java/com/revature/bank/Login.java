package com.revature.bank;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.AdminDao;
import com.revature.dao.CustomerDao;
import com.revature.daoimpl.AdminDaoImpl;
import com.revature.daoimpl.BankAccountDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.util.Log;

public class Login {
	static Scanner sc = new Scanner(System.in);
	static CustomerDao c = new CustomerDaoImpl();
	static AdminDao a = new AdminDaoImpl();
	
	public static void customerLoginInput() {
		System.out.println("Enter username: ");
		String inputName = sc.nextLine();
		System.out.println("Enter password: ");
		String inputPword = sc.nextLine();
		
		try {
			if(c.findCustomerByLogin(inputName, inputPword)) {
				System.out.println("Successfully logged in!");
				Log.LogIt("info", "Customer with account ID, " + BankAccountDaoImpl.currentBankID + " logged in.");
				System.out.println();
			} else {
				System.out.println("Invalid username or password.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void adminLogin() {
		System.out.println("Enter username: ");
		String inputName = sc.nextLine();
		System.out.println("Enter password: ");
		String inputPword = sc.nextLine();
		
		try {
			if(a.findAdminByLogin(inputName, inputPword)) {
				System.out.println("Successfully logged in!");
				Log.LogIt("info", "Admin logged in");
				System.out.println();
			} else {
				System.out.println("Invalid username or password.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
