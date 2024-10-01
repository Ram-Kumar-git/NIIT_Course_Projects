package com.jap.oops;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Initialize an empty list of students and courses
		Student[] students = getStudents();
		Course mathCourse = new MathCourse(201, "Calculus 101", true);
		Course programmingCourse = new ProgrammingCourse(301, "Java Programming", "Java");
		Course courses[] = {mathCourse, programmingCourse};
		StudentManagementSystem.displayMenu(scanner, students, courses);
		scanner.close();
	} //End of main

	private static Student[] getStudents() {
		return new Student[]{
				new Student(101, "John"),
				new Student(102, "Bob"),
				new Student(103, "Jenny"),
				new Student(104, "Harry"),
				new Student(105, "James"),
				new Student(106, "Thomas"),
				new Student(107, "Henry"),
				new Student(108, "Cathe"),
				new Student(109, "Coles")
		};
	}

}
