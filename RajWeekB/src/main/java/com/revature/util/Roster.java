package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Student;

public class Roster {
	public static List<Student> studentList = new ArrayList<Student>();
	
	public static Student findStudentByFirstName(String input) {
		for(int i = 0; i < studentList.size(); i++) {
			String name = studentList.get(i).getFirstName();
			if(input.equals(name)) {
				return studentList.get(i);
			}
		}
		System.out.println("Student not found");
		Menu.chooseOption();
		return null;
	}

}
