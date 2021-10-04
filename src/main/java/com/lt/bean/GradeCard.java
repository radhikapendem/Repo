package com.lt.bean;

/**
 * 
 * @author G4-FullStackGroup
 * GradeCard Class
 * 
 */
public class GradeCard {

	private int StudentId;
	private String CourseCode;
	private String CourseName;
	private String Grade;

	/**
	 * Default Constructor
	 * @return values
	 */
	public GradeCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public GradeCard(String courseCode, String courseName, String grade) {
		CourseCode = courseCode;
		CourseName = courseName;
		Grade = grade;
	}

	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public GradeCard(int studentId, String courseCode, String courseName, String grade) {
		super();
		StudentId = studentId;
		CourseCode = courseCode;
		CourseName = courseName;
		Grade = grade;
	}
	
	/**
	 * Method to get StudentId
	 * @param getStudentId
	 */
	public int getStudentId() {
		return StudentId;
	}

	/**
	 * Method to set StudentId
	 * @param setStudentId
	 */
	public void setStudentId(int studentId) {
		StudentId = studentId;
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
	 * Method to get Grade
	 * @param getGrade
	 */
	public String getGrade() {
		return Grade;
	}

	/**
	 * Method to set Grade
	 * @param set Grade
	 */
	public void setGrade(String grade) {
		Grade = grade;
	}
	
	
	@Override
	public String toString() {
		return "GradeCard [StudentId=" + StudentId + ", CourseId=" + CourseCode + ", Grade=" + Grade + "]";
	}


}