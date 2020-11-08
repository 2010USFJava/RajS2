package com.revature.record;

import com.revature.bank.BankAccount;
import com.revature.bank.Customer;
import com.revature.util.Database;
import com.revature.util.FileIO;

public class RecordList {
	
	public void viewCustomerInfo(Customer c) {
		FileIO.writeCustomerFile(Database.customerList);
	}
	
	public void viewAccountInfo(BankAccount b) {
		FileIO.writeAccountFile(Database.accountList);
	}

}
