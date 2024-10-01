package com.jap.oops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {
	Course mathCourse;
	Course programmingCourse;
	Student[] students;
	Student student;

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
		student = new Student(110, "Alice");
	}

	@After
	public void tearDown() throws Exception {
		mathCourse = null;
		programmingCourse = null;
		students = null;
		student = null;
	}

	@Test
	public void addStudentInMathCourse() {
		String result = mathCourse.addStudent(student);
		assertEquals("Alice has been added to the course: Calculus 101", result);
	}

	@Test
	public void addSameStudentInMathCourse() {
		mathCourse.addStudent(student);
		String result = mathCourse.addStudent(student);
		assertEquals("Alice has already been added to the course: Calculus 101", result);
	}


	@Test
	public void addMoreThanMaxStudentInMathCourse() {
		for (Student student : students) {
			mathCourse.addStudent(student);
		}
		String result = mathCourse.addStudent(student);
		assertEquals("Maximum students enrolled. Cannot add more students.", result);
	}

	@Test
	public void addStudentInProgrammingCourse() {
		String result = programmingCourse.addStudent(student);
		assertEquals("Alice has been added to the course: Java Programming", result);
	}

	@Test
	public void addMoreThanMaxStudentInProgrammingCourse() {
		for (Student student : students) {
			programmingCourse.addStudent(student);
		}
		String result = programmingCourse.addStudent(student);
		assertEquals("Maximum students enrolled. Cannot add more students.", result);
	}

	@Test
	public void viewEnrolledStudentsInMathCourse() {
		mathCourse.addStudent(student);
		String studentDetails = mathCourse.viewEnrolledStudents();
		assertEquals("Students Enrolled in the course Calculus 101:\n" +
				"1.Alice\n", studentDetails);
	}

	@Test
	public void viewEnrolledStudentsInProgrammingCourse() {
		programmingCourse.addStudent(student);
		String studentDetails = programmingCourse.viewEnrolledStudents();
		assertEquals("Students Enrolled in the course Java Programming:\n" +
				"1.Alice\n", studentDetails);
	}

	@Test
	public void getMathCourseDetail() {
		String expectedDetails = "Math Course Details:\nCourse ID: 201\nCourse Name: Calculus 101\nCalculus Required: true";
		assertEquals(expectedDetails, mathCourse.getCourseDetails());
	}

	@Test
	public void getProgrammingCourseDetail() {
		String expectedDetails = "Programming Course Details:\nCourse ID: 301\nCourse Name: Java Programming\nProgramming Language: Java";
		assertEquals(expectedDetails, programmingCourse.getCourseDetails());
	}
}
