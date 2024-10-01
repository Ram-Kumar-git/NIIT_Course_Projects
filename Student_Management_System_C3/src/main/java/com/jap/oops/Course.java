package com.jap.oops;

public abstract class Course {
	//declare the attributes courseID,courseName,enrolledStudents,enrolledStudentsCount
	private int courseID;
	private String courseName;
	private int maxStudents;
	private Student enrolledStudents [];
	private int enrolledStudentsCount=0;


	// Constructor that accepts only courseId and courseName

	public Course(int courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.maxStudents=10;
		this.enrolledStudents = new Student[maxStudents];

	}

	// Assuming a maximum of 10 enrolled students initially

	// Getter and Setter Methods

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Student[] getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(Student[] enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	// Method to add a student to the course
	public String addStudent(Student student) {
		if(isEnrolled(student)){
			return student.getStudentName()+" has already been added to the course: "+courseName;
		}
		if(enrolledStudentsCount<maxStudents){
			enrolledStudents[enrolledStudentsCount++]= student;
			return student.getStudentName()+" has been added to the course: "+courseName;
		}
		else {
			return "Maximum students enrolled. Cannot add more students.";
		}
	}

	public boolean isEnrolled(Student student) {

		for(int i = 0; i < enrolledStudentsCount;i++){
			if(enrolledStudents[i].equals(student)){
				return true;
			}
		}return false;
	}

	// Method to view enrolled students in the course
	public String viewEnrolledStudents() {
		String result = "Students Enrolled in the course " + courseName + ":\n";
		for (int i = 0; i < enrolledStudentsCount; i++) {
			result =result + (i + 1) + "." + enrolledStudents[i].getStudentName() + "\n";
		}
		return result;
	}


	// Abstract method to get specific course details (to be implemented by derived classes)
	public abstract String getCourseDetails();
}
