package com.lt.exception;
/**
 * 
 * @author G4-FullStackGroup
 * Implementations of CourseLimitExceedException extends Exception
 * 
 */
public class CourseLimitExceedException extends Exception{
	
	private int num;

	
	public CourseLimitExceedException(int num )
	{	
		this.num = num;
	}


	@Override
	public String getMessage() 
	{
		return "You have already registered for " + num + " courses";
	}


}
