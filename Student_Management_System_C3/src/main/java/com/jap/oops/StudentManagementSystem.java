package com.jap.oops;

import java.util.Scanner;

public class StudentManagementSystem {
	static void displayMenu(Scanner scanner, Student[] students, Course[] courses) {
		do{
			System.out.println("Student Management System Menu : \n 1. Enroll Students for the Course. \n 2. View the Enrollement details of the Students. \n 3. Explore Course details. \n 4. Exit.");
			System.out.println("Enter Your Choice");
			int choice = scanner.nextInt();

			switch(choice){
				case 1:
					System.out.println("Enroll in a Course :");
					Student selectedStudents = getStudent(scanner,students);
					if(selectedStudents==null){
						System.out.println("Invalid Student Selection. Please Try Again");
						continue;
					}
					System.out.println("Available Course :");
					Course selectedCourses = getCourse(scanner,courses);
					if(selectedCourses==null){
						System.out.println("Invalid Course Selection. Please Try Again");
						continue;
					}
					enrollStudentInCourse(selectedStudents,selectedCourses);
					break;
				case 2:
					selectedStudents=getStudent(scanner,students);
					String detail=viewStudentEnrollmentDetails(selectedStudents,students);
					System.out.println(detail);
					break;
				case 3:
					System.out.println("Select a course to view enrolled students");
					selectedCourses = getCourse(scanner,courses);
					String detail1=viewEnrolledStudentsInCourse(selectedCourses,courses);
					System.out.println(detail1);
					break;
				case 4:
					System.out.println("Exiting....");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option. Try again");
					break;
			}
		}while(true);

	}

	private static Student getStudent(Scanner scanner, Student[] students) {
		System.out.println("Available Students: ");
		for(int i=0;i<students.length;i++) {
			System.out.println((i+1)+". "+students[i].getStudentName() +" "+students[i].getStudentID());
		}
		System.out.print("Enter student number: ");
		int studentnum = scanner.nextInt();
		System.out.println();
		if(studentnum >= 1 && studentnum<=students.length){
			return students[studentnum-1];
		}
		return null;

	}

	private static Course getCourse(Scanner scanner, Course[] courses) {
//     System.out.println("Available Courses: ");
		for(int i=0;i<courses.length;i++)
		{
			System.out.println((i+1)+". "+courses[i].getCourseName() +" ");
		}
		System.out.print("Enter course number: ");
		int coursenum = scanner.nextInt();
		System.out.println();
		if(coursenum >=1 && coursenum <=courses.length) {
			return courses[coursenum - 1];
		}
		return null;

	}

	public static boolean enrollStudentInCourse(Student selectedStudent, Course selectedCourse) {
		//Checking condition
		if(selectedStudent==null || selectedCourse==null) {
			System.out.println("Student and Course cannot be null");
			return false;
		}
		//Enrolled
		String enrollmentResult = selectedStudent.enrollInCourse(selectedCourse);
		if(enrollmentResult!=null) {
			System.out.println(enrollmentResult+"\n");
		}
		else {
			System.out.println("Enrollment failed for " + selectedStudent.getStudentName());
			return false; // Return false indicating enrollment failure
		}
		//Add students
		String enrollment = selectedCourse.addStudent(selectedStudent);
		return  true;

	}

	public static String viewStudentEnrollmentDetails(Student selectedStudent, Student[] students) {
		String result = "\nView Enrollment Details:\n";
		result += "Enrollment Details for " + selectedStudent.getStudentName() + ":\n";

		Course[] enrolledCourses = selectedStudent.getEnrolledCourses();
		for (Course course : enrolledCourses) {
			if (course != null) {
				result += course.getCourseDetails() + "\n-----------------------\n";
			}
		}
		return result;
	}

	public static String viewEnrolledStudentsInCourse(Course selectedCourse, Course[] courses) {
		String result = "Students Enrolled in the course " + selectedCourse.getCourseName() + ":\n";
		Student[] enrolledStudents = selectedCourse.getEnrolledStudents();

		for (int i = 0; i < enrolledStudents.length; i++) {
			if (enrolledStudents[i] != null) {
				result += (i + 1) + "." + enrolledStudents[i].getStudentName() + "\n";
			}
		}
		return result;
	}

}