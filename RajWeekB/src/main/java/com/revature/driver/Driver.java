package com.revature.driver;

import com.revature.util.FileIO;
import com.revature.util.Menu;

public class Driver {
	static {FileIO.readStudentFile();}
	public static void main(String[] args) {
		Menu.chooseOption();
	}

}
