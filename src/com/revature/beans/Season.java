package com.revature.beans;

public class Season {
	private String name;
	private String weather;
	private Holiday holiday;
	
	public Season() {}
	
	public Season(String name, String weather, Holiday holiday) {
		this.name=name;
		this.weather=weather;
		this.holiday=holiday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public Holiday getHoliday() {
		return holiday;
	}

	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}

	@Override
	public String toString() {
		return "Season [name=" + name + ", weather=" + weather + ", holiday=" + holiday + "]";
	}

}