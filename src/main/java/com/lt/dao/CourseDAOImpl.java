package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Course;
import com.lt.utils.DBUtil;

public class CourseDAOImpl implements CourseDAOInterface
{

private static volatile CourseDAOImpl instance = null;
	
	private CourseDAOImpl()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static CourseDAOImpl getInstance()
    {
    if(instance == null)
    {
    synchronized(CourseDAOImpl.class){
    instance = new CourseDAOImpl();
    }
    }
    return instance;
    }
    
	public List<Course> getCourse() 
	{
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		List<Course> courseList = new ArrayList<Course>();
		try 
		{
			connection = DBUtil.getConnection();

			String str = "select course_code, course_name, prof_id, course_fee from course";

			preparedStatement = connection.prepareStatement(str);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				String courseCode = resultSet.getString("course_code");
				String courseName = resultSet.getString("course_name");
				String profId = resultSet.getString("prof_id");
				double courseFee = resultSet.getDouble("course_fee");
				
				Course obj = new Course(courseCode, courseName, profId, courseFee);
				courseList.add(obj);
			}

		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return courseList;

	}

	@Override
	public String getCourseById(String courseId) {

		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try 
		{
			connection = DBUtil.getConnection();

			String str = "select course_name from course where course_code = ?";

			preparedStatement=connection.prepareStatement(str);
			preparedStatement.setString(1,courseId);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				return resultSet.getString("course_name");

			}
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return null;
	}
	
	@Override
	public double getFeeById(String courseCode) {

		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try 
		{
			connection = DBUtil.getConnection();

			String str = "select course_fee from course where course_code = ?";

			preparedStatement=connection.prepareStatement(str);
			preparedStatement.setString(1,courseCode);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				return resultSet.getDouble("course_fee");

			}
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	@Override
	public boolean addCourse(String courseCode, String courseName) {
		// TODO Auto-generated method stub
		return false;
	}

	

	/*
	 * public String addCourse() { Scanner in = new Scanner(System.in);
	 * System.out.println("Enter course Id: "); String courseId = in.next();
	 * System.out.println("Enter course Name: "); String courseName = in.next();
	 * //course.add(new Course(courseId, courseName));
	 * 
	 * return "updated successfully"; }
	 */

}
