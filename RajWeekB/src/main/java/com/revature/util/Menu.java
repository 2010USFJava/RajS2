package com.revature.util;

import java.util.Scanner;

import com.revature.beans.Student;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	
	public static void chooseOption() {
		System.out.println("Welcome!");
		System.out.println("Please choose one of the following options:");
		System.out.println("[a]dd new student");
		System.out.println("[v]iew average");
		System.out.println("[e]xit");
		
		String option = sc.nextLine();
		
		switch(option.toLowerCase()) {
			case "a":
				addStudent();
				break;
			case "v":
				Student student = new Student();
				viewAverage(student);
				break;
			case "e":
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Something went wrong, please try again.");
				chooseOption();
		}
		
	}
	
	public static void addStudent() {
		System.out.println("Enter student's first name:");
		String fName = sc.nextLine();
		System.out.println("Enter student's last name:");
		String lName = sc.nextLine();
		System.out.println("Enter student's first test score:");
		int fScore = Integer.parseInt(sc.nextLine());
		System.out.println("Enter student's second test score:");
		int sScore = Integer.parseInt(sc.nextLine());
		
		Student newStudent = new Student(fName, lName, fScore, sScore);
		Log.LogIt("info", newStudent.getFirstName() + " " + newStudent.getLastName() + " was added");
		System.out.println(Roster.studentList.toString());
		
		System.out.println("Do you want to add another student? (y/n)");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			addStudent();
		} else {
			chooseOption();			
		}
		
	}
	
	public static void viewAverage(Student s) {
		System.out.println("Enter first name of student:");
		String fName = sc.next();
		s = Roster.findStudentByFirstName(fName);
		double average = (s.getFirstTestScore() + s.getSecondTestScore()/2);
		System.out.println(s.getFirstName() + " " + s.getLastName() + "'s average is: " + average);
		Log.LogIt("info", "Average of " + s.getFirstName() + " " + s.getLastName() + " is: " + average);
	}

}
