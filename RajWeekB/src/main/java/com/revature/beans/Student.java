package com.revature.beans;

import java.io.Serializable;

import com.revature.util.FileIO;
import com.revature.util.Log;
import com.revature.util.Roster;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5807779060247880786L;
	private String firstName;
	private String lastName;
	private int firstTestScore;
	private int secondTestScore;
	
	public Student() {
		super();
		Roster.studentList.add(this);
		FileIO.writeStudentFile(Roster.studentList);
	}

	public Student(String firstName, String lastName, int firstTestScore, int secondTestScore) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.firstTestScore = firstTestScore;
		this.secondTestScore = secondTestScore;
		FileIO.writeStudentFile(Roster.studentList);
		Log.LogIt("info", "A new student, " + this.firstName + " " + this.lastName + ", has been added");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getFirstTestScore() {
		return firstTestScore;
	}

	public void setFirstTestScore(int firstTestScore) {
		this.firstTestScore = firstTestScore;
	}

	public int getSecondTestScore() {
		return secondTestScore;
	}

	public void setSecondTestScore(int secondTestScore) {
		this.secondTestScore = secondTestScore;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", firstTestScore=" + firstTestScore
				+ ", secondTestScore=" + secondTestScore + "]";
	}

}
