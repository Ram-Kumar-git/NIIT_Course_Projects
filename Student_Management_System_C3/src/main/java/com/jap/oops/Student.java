package com.jap.oops;

public class Student {
	//declare the attributes enrolledCoursesCount,studentID,studentName,enrolledCourses
	private int enrolledCourseCount;
	private int studentID;
	private String studentName;
	private Course[] enrolledCourses;
	private final int MAX_COURSE = 2;

	// generate the Constructor with studentId and studentName

	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.enrolledCourses=new Course[MAX_COURSE];
		this.enrolledCourseCount=0;

	}

	//generate the getter and setter

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Course[] getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(Course[] enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public String enrollInCourse(Course course) {

		 if(isEnrolled(course)){
			 return studentName+" is already enrolled in "+course.getCourseName();
		 }
		 if(enrolledCourseCount < enrolledCourses.length){
			 enrolledCourses[enrolledCourseCount++] = course;
			 return getStudentName() + " has been enrolled in " + course.getCourseName();
		 }
		 else{
			 return studentName+" has enrolled for maximum courses";
		 }
	}

	// Check if already enrolled in a course
	public boolean isEnrolled(Course course) {
		for(int  i=0;i<enrolledCourseCount;i++){
			if(enrolledCourses[i].equals(course)){
				return true;
			}
		}
		return false;
	}

}
