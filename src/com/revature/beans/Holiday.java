package com.revature.beans;

public class Holiday {
	private String name;
	private String month;
	private int day;

	public Holiday() {}
	
	public Holiday(String name, String month, int day) {
		this.name=name;
		this.month=month;
		this.day=day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Holiday [name=" + name + ", month=" + month + ", day=" + day + "]";
	}

}