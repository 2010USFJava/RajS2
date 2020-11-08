package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.BankAccount;
import com.revature.bank.Customer;

public class FileIO {
	public static final String customerFile = "customerList.txt";
	public static final String accountFile = "accountList.txt";
	
	public static void writeCustomerFile(List<Customer> cList) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(customerFile));
			objOut.writeObject(cList);
			objOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readCustomerFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(customerFile));
			Database.customerList = (ArrayList<Customer>)objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeAccountFile(List<BankAccount> aList) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(accountFile));
			objOut.writeObject(aList);
			objOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readAccountFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(accountFile));
			Database.accountList = (ArrayList<BankAccount>)objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
