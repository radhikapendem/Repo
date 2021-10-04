package com.lt.bean;
/**
 * 
 * @author G4-FullStackGroup
 * catalog Class
 * 
 */

public class Catlog {	
	public String CourseCode;
	public String CourseName;
	public double CourseFee;
	
	/**
	 * Default Constructor
	 * @return values
	 */
	
	public Catlog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public Catlog(String courseCode, String courseName, double courseFee) {
		super();
		CourseCode = courseCode;
		CourseName = courseName;
		CourseFee = courseFee;
	}
	
	/**
	 * Method to get CourseCode
	 * @param getCourseCode
	 */
	public String getCourseCode() {
		return CourseCode;
	}
	/**
	 * Method to set CourseCode
	 * @param setCourseCode
	 */
	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}
	/**
	 * Method to get CourseName
	 * @param getCourseName
	 */
	public String getCourseName() {
		return CourseName;
	}
	/**
	 * Method to set CourseName
	 * @param setCourseName
	 */
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	/**
	 * Method to get CourseFee
	 * @param getCourseFee
	 */
	public double getCourseFee() {
		return CourseFee;
	}
	/**
	 * Method to set CourseFee
	 * @param setCourseFee
	 */
	public void setCourseFee(double courseFee) {
		CourseFee = courseFee;
	} 
	
	
	
	
}