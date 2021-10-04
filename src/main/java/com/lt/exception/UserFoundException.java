package com.lt.exception;

public class UserFoundException extends Exception
{
	private String userId;

	/**
	 * 
	 * @param userId
	 */
	public UserFoundException(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}

}
