package com.lt.exception;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of StudentNotRegisteredException extends Exception
 * 
 */
public class StudentNotRegisteredException extends Exception{
	 private String studentName;
	 
	 public StudentNotRegisteredException(String studentName)
	 {
		 this.studentName=studentName;
	 }
	 
	 public String getStudentName()
	 {
		 return studentName;
	 }
	 
}
