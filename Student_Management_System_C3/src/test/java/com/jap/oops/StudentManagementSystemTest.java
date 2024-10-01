package com.jap.oops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentManagementSystemTest {
	Course courses[];
	private Course mathCourse;
	private Course programmingCourse;
	private Student[] students;
	private Student student;
	private StudentManagementSystem studentManagementSystem;

	@Before
	public void setUp() throws Exception {
		mathCourse = new MathCourse(201, "Calculus 101", true);
		programmingCourse = new ProgrammingCourse(301, "Java Programming", "Java");
		students = new Student[]{
				new Student(101, "John"),
				new Student(102, "Bob"),
				new Student(103, "Jenny"),
				new Student(104, "Harry"),
				new Student(105, "James"),
				new Student(106, "Thomas"),
				new Student(107, "Henry"),
				new Student(108, "Cathe"),
				new Student(109, "Coles"),
				new Student(110, "Peter")
		};
		student = new Student(111, "Alice"); // Change ID to make it unique
		studentManagementSystem = new StudentManagementSystem();
		courses = new Course[]{mathCourse, programmingCourse};
	}

	@After
	public void tearDown() throws Exception {
		mathCourse = null;
		programmingCourse = null;
		students = null;
		student = null;
		studentManagementSystem = null;
		courses = null;
	}

	@Test
	public void enrollStudentInCourse() {
		assertTrue(studentManagementSystem.enrollStudentInCourse(student, mathCourse));
		assertTrue(studentManagementSystem.enrollStudentInCourse(student, programmingCourse));
	}

	@Test
	public void viewStudentEnrollmentDetails() {
		studentManagementSystem.enrollStudentInCourse(student, mathCourse);
		studentManagementSystem.enrollStudentInCourse(student, programmingCourse);

		String expectedDetails = "\nView Enrollment Details:\n" +
				"Enrollment Details for Alice:\n" +
				"Math Course Details:\n" +
				"Course ID: 201\n" +
				"Course Name: Calculus 101\n" +
				"Calculus Required: true\n" +
				"-----------------------\n" +
				"Programming Course Details:\n" +
				"Course ID: 301\n" +
				"Course Name: Java Programming\n" +
				"Programming Language: Java\n" + "-----------------------\n";
		assertEquals(expectedDetails, studentManagementSystem.viewStudentEnrollmentDetails(student, students));
	}

	@Test
	public void viewEnrolledStudentsInCourse() {
		for (Student student : students) {
			studentManagementSystem.enrollStudentInCourse(student, mathCourse);
		}

		String expectedEnrolledStudents = "Students Enrolled in the course Calculus 101:\n" +
				"1.John\n" +
				"2.Bob\n" +
				"3.Jenny\n" +
				"4.Harry\n" +
				"5.James\n" +
				"6.Thomas\n" +
				"7.Henry\n" +
				"8.Cathe\n" +
				"9.Coles\n" +
				"10.Peter\n";

		assertEquals(expectedEnrolledStudents, studentManagementSystem.viewEnrolledStudentsInCourse(mathCourse, courses));
	}
}