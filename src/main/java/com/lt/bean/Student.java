package com.lt.bean;
/**
 * 
 * @author G4-FullStackGroup
 * Student Class
 * 
 */

public class Student {

	private int StudentId;
	private String StudentName;
	private String StudentEmailId;
	private String StudentAddress;
	private String Branch;
	private Long StudentContactNo;
	private int IsApproved;
	private String Password;
	

	/**
	 *Default Constructor
	 * @return values
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String studentName, String studentEmailId, String studentAddress, String branch,
			Long studentContactNo, String password) {
		super();
		StudentName = studentName;
		StudentEmailId = studentEmailId;
		StudentAddress = studentAddress;
		Branch = branch;
		StudentContactNo = studentContactNo;
		Password = password;
	}


	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public Student(int studentId, String studentName, String studentEmailId, String studentAddress, String branch,
			Long studentContactNo) {

		StudentId = studentId;
		StudentName = studentName;
		StudentEmailId = studentEmailId;
		StudentAddress = studentAddress;
		Branch = branch;
		StudentContactNo = studentContactNo;
	}

	
	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public Student(int studentId, String studentName) {
		super();
		StudentId = studentId;
		StudentName = studentName;
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
	 * Method to get StudentName
	 * @param getStudentName
	 */
	public String getStudentName() {
		return StudentName;
	}
	/**
	 * Method to set StudentName
	 * @param setStudentName
	 */
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	/**
	 * Method to get StudentContactNo
	 * @param getStudentContactNo
	 */
	public Long getStudentContactNo() {
		return StudentContactNo;
	}
	/**
	 * Method to set StudentContactNo
	 * @param setStudentContactNo
	 */
	public void setStudentContactNo(Long studentContactNo) {
		StudentContactNo = studentContactNo;
	}
	/**
	 * Method to get StudentEmailId
	 * @param getStudentEmailId
	 */
	public String getStudentEmailId() {
		return StudentEmailId;
	}
	/**
	 * Method to set StudentEmailId
	 * @param setStudentEmailId
	 */
	public void setStudentEmailId(String studentEmailId) {
		StudentEmailId = studentEmailId;
	}
	/**
	 * Method to get StudentAddress
	 * @param getStudentAddress
	 */
	public String getStudentAddress() {
		return StudentAddress;
	}
	/**
	 * Method to set StudentAddress
	 * @param setStudentAddress
	 */
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	/**
	 * Method to get Branch
	 * @param getBranch
	 */
	public String getBranch() {
		return Branch;
	}
	/**
	 * Method to get Branch
	 * @param getBranch
	 */
	public void setBranch(String branch) {
		Branch = branch;
	}
	/**
	 * Method to get IsApproved
	 * @param getIsApproved
	 */
	public int getIsApproved() {
		return IsApproved;
	}
	/**
	 * Method to setIsApproved
	 * @param setIsApproved
	 */
	public void setIsApproved(int isApproved) {
		IsApproved = isApproved;
	}

	
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StudentContactNo="
				+ StudentContactNo + ", StudentEmailId=" + StudentEmailId + ", StudentAddress=" + StudentAddress + "]";
	}


}