package com.lt.business;

import java.sql.SQLException;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.GradeCard;
import com.lt.bean.RegisteredCourse;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeNotAddedException;

/**
 * 
 * Interface for Professor Operations
 * 
 */
public interface ProfessorInterface {
	
	/**
	 * Method to grade a Student
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 * @return boolean indicating if grade is added or not
	 * @throws GradeNotAddedException
	 */
	public boolean addGrade(String courseName, String courseCode,String grade,int studentId) throws GradeNotAddedException;
	
	/**
	 * Method to view all the enrolled students
	 * @param profId: professor id 
	 * @return List of enrolled students
	 */
	public boolean getRegisteredCourses(String profId) throws SQLException;
	
	/**
	 * Method to get list of all course a professor is teaching
	 * @param profId: professor id 
	 * @return List of courses the professor is teaching
	 * @throws CourseNotFoundException 
	 */
	public List<Course> getCourses() throws CourseNotFoundException;
	
	/**
	 * Method to get the professor name with ID
	 * @param profId
	 * @return Professor name 
	 */
	public String getProfessorById(String profId);
}

