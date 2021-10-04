package com.lt.bean;

/**
 * 
 * @author G4-FullStackGroup
 * SemesterRegistration Class
 * 
 */
public class SemesterRegistration 
{
	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public SemesterRegistration(int studentId, String studentname, int semester) {
		super();
		this.studentId = studentId;
		Studentname = studentname;
		this.semester = semester;
	}


	private int studentId;
	private String Studentname;
	private int semester;
	/**
	 * Method to getStudentId
	 * @param getStudentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * Method to set StudentId
	 * @param setStudentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * Method to get Student name
	 * @param getStudentname
	 */
	public String getStudentname() {
		return Studentname;
	}
	/**
	 * Method to set Student name
	 * @param setStudentname
	 */
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	/**
	 * Method to get Semester
	 * @param getSemester
	 */
	public int getSemester() {
		return semester;
	}
	/**
	 * Method to set Semester
	 * @param setSemester
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

}