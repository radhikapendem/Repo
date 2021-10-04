package com.lt.exception;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of CourseFoundException extends Exception
 * 
 */
public class CourseFoundException extends Exception{
	private String courseCode;
	
	public CourseFoundException(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	@Override
	public String getMessage() {
		return "courseCode: " + courseCode + " already present in catalog!";
	}


}
