package com.lt.exception;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of FileNotFoundException extends Exception
 * 
 */
public class GradeNotAddedException extends Exception{

	private int studentId;
	 
	 public GradeNotAddedException(int studentId)
	 {
		 this.studentId=studentId;
	 }
	 
	 public int getStudentId()
	 {
		 return studentId;
	 }

}
