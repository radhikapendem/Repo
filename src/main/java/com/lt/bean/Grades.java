package com.lt.bean;

/**
 * 
 * @author G4-FullStackGroup
 * Grades Class
 * 
 */
public class Grades {

	private String CourseId;
	private String CourseName;
	private String Grade;
	private int StudentId;
	
	
	public Grades() {}
	
	
	
	public Grades(String courseId, String courseName, String grade, int studentId) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		Grade = grade;
		StudentId = studentId;
	}



	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	
	
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	@Override
	public String toString() {
		return "Grades [StudentId=" + StudentId + ", Grade=" + Grade + ", CourseId=" + CourseId + "]";
	}
	
	
}
