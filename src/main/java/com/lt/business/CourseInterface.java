package com.lt.business;

/**
 * 
 * @author G4-FullStackGroup
 * Interface for Admin Operations
 * 
 */
import java.util.List;

import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;

import java.util.List;

public interface CourseInterface {
	/**
	    * Method to createCourse
	    * @return
	    */
	public String createCourse();
	/**
	    * Method to listCourse
	    * @return
	    */
	public String listCourse();
	/**
	    * Method toupdateCourse
	    * @return
	    */
	public String updateCourse(Course course);
	/**
	    * Method to deleteCourse
	    * @return
	    */
	public String deleteCourse(String CourseId);
	/**
	    * Method to viewCourses
	    * @return
	 * @throws CourseNotFoundException 
	    */
	public List<Course> viewCourses() throws CourseNotFoundException;
	
	
}