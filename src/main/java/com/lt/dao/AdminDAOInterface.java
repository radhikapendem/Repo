package com.lt.dao;

import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;

/**
 * @author G4-FullStackGroup
 * Interface for Admin Dao Operations
 *
 */
public interface AdminDAOInterface 
{
	//public List<Admin> getAdminCredential();
	
	/**
	 * Approve Student using SQL commands
	 * @param studentName
	 * @throws StudentNotFoundException
	 */
	public boolean adminApproval(int studentId);
	//public void addprofessor(int ProfId, String name, Long contact, String emailId, String address);
	/**
	 * Add Course using SQL commands
	 * @param courseId,courseName
	 * @throws CourseFoundException
	 */
	public boolean addCourse(String courseCode, String courseName, double courseFee) throws CourseFoundException;
	
	/**
	 * Delete Course using SQL commands
	 * @param courseId,courseName
	 * @throws CourseNotFoundException
	 */
	public boolean deleteCourse(String courseId, String courseName) throws CourseNotFoundException;
}








