package com.lt.exception;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of StudentNotRegisteredException extends Exception
 * 
 */
public class StudentNotFoundException extends Exception {
	private int studentId;
	
	public StudentNotFoundException(int studentId) {
		this.studentId = studentId;
	}
	
	public int getStudentId() {
		return this.studentId;
	}
	
	@Override
	public String getMessage() {
		return "studentId: " + studentId + " not found!" ;
	}
}
