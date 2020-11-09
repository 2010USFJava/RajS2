package com.revature.record;

import com.revature.bank.BankAccount;
import com.revature.bank.Customer;
import com.revature.util.Database;
import com.revature.util.FileIO;
import com.revature.util.Logging;

public class RecordList {
	
	public void viewCustomerInfo(Customer c) {
		FileIO.writeCustomerFile(Database.customerList);
		//Logging.LogIt("info", "written to customer list");
	}
	
	public void viewAccountInfo(BankAccount b) {
		FileIO.writeAccountFile(Database.accountList);
		//Logging.LogIt("info", "written to account list");
	}

}
