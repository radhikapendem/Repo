package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.RegisteredCourse;
import com.lt.utils.DBUtil;

public class RegisteredCourseDAOImpl  implements RegisteredCourseDAOInterface
{


	private static volatile RegisteredCourseDAOImpl instance = null;
	
	private RegisteredCourseDAOImpl()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static RegisteredCourseDAOImpl getInstance()
    {
    if(instance == null)
    {
    synchronized(RegisteredCourseDAOImpl.class){
    instance = new RegisteredCourseDAOImpl();
    }
    }
    return instance;
    }

    
	@Override
	public List<RegisteredCourse> viewRegisteredCourses(int studentId) {

		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		List<RegisteredCourse> availRegCourseList = new ArrayList<>();
		try 
		{

			connection = DBUtil.getConnection();

			String str = "select course_code, course_name, course_fee from registered_course where student_id = ?";

			preparedStatement = connection.prepareStatement(str);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				String courseCode = resultSet.getString("course_code");
				String courseName = resultSet.getString("course_name");
				double courseFee = resultSet.getDouble("course_fee");
				RegisteredCourse obj = new RegisteredCourse(courseCode, courseName, courseFee);
				availRegCourseList.add(obj);
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


		return availRegCourseList;
	}

	@Override
	public boolean addCourses(String courseCode, String courseName, double courseFee, int studentId) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		try {
			connection=DBUtil.getConnection();
			String query = "insert into registered_course(course_code, course_name, course_fee, student_id) values (?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);


			preparedStatement.setString(1, courseCode);
			preparedStatement.setString(2, courseName);
			preparedStatement.setDouble(3, courseFee);
			preparedStatement.setInt(4, studentId);
			int row = preparedStatement.executeUpdate();
			if(row==1)
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;

	}

	@Override
	public boolean dropCourse(String courseCode, int studentId) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try
		{
			connection=DBUtil.getConnection();
			String query = "delete from registered_course where course_code = ? AND student_id = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, courseCode);
			preparedStatement.setInt(2, studentId);
			preparedStatement.execute();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception found" + e.getMessage());
		}
		return false;

	}
	
}


