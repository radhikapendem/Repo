package com.lt.bean;

/**
 * 
 * @author G4-FullStackGroup
 * Course Class
 * 
 */

public class Course {

	private String CourseCode;
	private String CourseName;
	private String ProfId;
	public double CourseFee;
	/**
	 *Default Constructor
	 * @return values
	 */
	public Course() {}
	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public Course(String courseCode, String courseName, String profId, double courseFee) {
		super();
		CourseCode = courseCode;
		CourseName = courseName;
		ProfId = profId;
		CourseFee = courseFee;
	}
	
	public Course(String courseId, String courseName) {
		super();
		CourseCode = courseId;
		CourseName = courseName;
	}


	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public Course(String courseCode, String courseName, String profId) {
		super();
		CourseCode = courseCode;
		CourseName = courseName;
		ProfId = profId;
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
	public void setCourseCode(String courseId) {
		CourseCode = courseId;
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
	 * Method to get ProfId
	 * @param getProfId
	 */
	public String getProfId() {
		return ProfId;
	}
	/**
	 * Method to set ProfId
	 * @param setProfId
	 */
	public void setProfId(String profId) {
		ProfId = profId;
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
	@Override
	public String toString() {
		return "Course [CourseCode=" + CourseCode + ", CourseName=" + CourseName + ", ProfId=" + ProfId + ", CourseFee="
				+ CourseFee + "]";
	}
	

}