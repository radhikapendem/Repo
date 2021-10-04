package com.lt.dao;

import java.util.List;

import com.lt.bean.RegisteredCourse;

public interface RegisteredCourseDAOInterface {


	List<RegisteredCourse> viewRegisteredCourses(int studentId);

	public boolean addCourses(String courseCode, String courseName, double courseFee, int studentId);

	public boolean dropCourse(String courseCode, int studentId);

}
