package com.lt.exception;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of CourseNotFoundException extends Exception
 * 
 */
public class CourseNotFoundException extends Exception{
	private String courseCode;
	
	public CourseNotFoundException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	public String getCourseCode()
	{
		return courseCode;
	}
	
	@Override
	public String getMessage() 
	{
		return "Course : " + courseCode + " not found!";
	}
}
