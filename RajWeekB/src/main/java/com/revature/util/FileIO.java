package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Student;

public class FileIO {
	public static final String studentFile = "studentList.txt";
	
	public static void writeStudentFile(List<Student> sList) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentFile));
			out.writeObject(sList);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readStudentFile() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentFile));
			Roster.studentList = (ArrayList<Student>)in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
