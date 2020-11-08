package com.revature.driver;

import com.revature.menu.Menu;
import com.revature.util.Database;
import com.revature.util.FileIO;

public class Driver {
	static {
		FileIO.readCustomerFile();
		FileIO.readAccountFile();
	}
	public static void main(String[] args) {
		
		Menu.mainMenu();
		Database.printList();
	}

}
