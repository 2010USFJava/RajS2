package com.revature.driver;

import com.revature.beans.Holiday;
import com.revature.beans.Season;

public class Driver {

	public static void main(String[] args) {
		Holiday hoilday1 = new Holiday("Christmas", "December", 25);
		Season season1 = new Season("Winter", "Snowing", hoilday1);
		System.out.println(season1);
	}

}