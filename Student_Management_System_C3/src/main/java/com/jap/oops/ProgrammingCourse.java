package com.jap.oops;

public class ProgrammingCourse extends Course {
	//declare the attributes
	private String programmingLanguage;

	// Constructor

	public ProgrammingCourse(int courseID, String courseName, String programmingLanguage) {
		super(courseID, courseName);
		this.programmingLanguage = programmingLanguage;
	}

	// Getter and setter for programmingLanguage

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	// Override getCourseDetails method to provide math course details
	@Override
	public String getCourseDetails() {
		return "Programming Course Details:\nCourse ID: "+getCourseID()+"\nCourse Name: "+getCourseName()+"\nProgramming Language: "+programmingLanguage ;
	}
}
