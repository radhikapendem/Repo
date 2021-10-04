package com.lt.exception;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of ProfessorNotAddedException extends Exception
 * 
 */
public class ProfessorNotAddedException extends Exception{
	private String professorId;
	
	public ProfessorNotAddedException(String professorId) {
		this.professorId = professorId;
	}
	
	public String getUserId() {
		return this.professorId;
	}
	
	@Override
	public String getMessage() {
		return "professorId: " + professorId + " not added!";
	}
}
