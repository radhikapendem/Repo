package com.lt.dao;

import java.util.List;

import com.lt.bean.Course;

/**
 * 
 * Interface for Course Operations
 *
 */
public interface CourseDAOInterface {	
	
	/**
	 * Method to list student
	 * @return list of student
	 */
	
	
	public List<Course> getCourse();
	
	/**
	 * Method to return course Name
	 * @param courseCode
	 * @return course by Id.
	 */
	
	
	public String getCourseById(String courseId);
	
	/**
	 * Method to add student to database
	 * @param courseCode
	 * @param courseName
	 * @return true if student is added, else false
	 */
	public boolean addCourse(String courseCode, String courseName);

	public double getFeeById(String courseCode);

}
