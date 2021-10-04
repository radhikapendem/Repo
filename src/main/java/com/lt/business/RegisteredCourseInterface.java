package com.lt.business;

import java.sql.SQLException;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;
import com.lt.exception.CourseLimitExceedException;
import com.lt.exception.CourseNotFoundException;

public interface RegisteredCourseInterface 
{

	public boolean getStudentDetails(int studentId, String name,int semester);
	public String getCourseDetails();
	List<RegisteredCourse> viewRegCourses(int studentId) throws CourseNotFoundException;
	public boolean dropCourse(String courseCode, int studentId, List<RegisteredCourse> registeredCourseList);
	boolean addCourse(String courseCode, int studentId, List<Course> courseList,
			List<RegisteredCourse> registeredCourseList);
	boolean regCourse(String courseCode, int studentId) throws CourseLimitExceedException;
	
	
	
	
}
