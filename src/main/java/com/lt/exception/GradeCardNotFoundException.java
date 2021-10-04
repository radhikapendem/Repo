package com.lt.exception;

public class GradeCardNotFoundException extends Exception
{
	private int studentId;
	public GradeCardNotFoundException(int studentId) 
	{
		this.studentId = studentId;
	}
	public int getStudentId()
	{
		return studentId;
	}
}
