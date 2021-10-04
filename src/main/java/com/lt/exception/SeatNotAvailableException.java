package com.lt.exception;


/**
 * 
 * @author G4-FullStackGroup
 * Implementations of SeatNotAvailableException extends Exception
 * 
 */
public class SeatNotAvailableException extends Exception{
	
	private String courseCode;

	public SeatNotAvailableException(String courseCode)
	{	
		this.courseCode = courseCode;
	}



	@Override
	public String getMessage() {
		return  "Seats are not available in course : " + courseCode;
	}


}
