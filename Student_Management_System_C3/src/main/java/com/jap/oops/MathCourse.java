package com.jap.oops;

public class MathCourse extends Course {
	//declare the attributes
	private boolean calculusRequired;

	// Constructor

	public MathCourse(int courseID, String courseName, boolean calculusRequired) {
		super(courseID, courseName);
		this.calculusRequired = calculusRequired;
	}

	// Getter and setter for calculusRequired


	public boolean isCalculusRequired() {
		return calculusRequired;
	}

	public void setCalculusRequired(boolean calculusRequired) {
		this.calculusRequired = calculusRequired;
	}

	// Override getCourseDetails method to provide math course details
	@Override
	public String getCourseDetails() {
		return "Math Course Details:\nCourse ID: "+getCourseID()+"\nCourse Name: "+getCourseName()+"\nCalculus Required: "+calculusRequired;
	}
}
