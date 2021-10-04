package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.GradeCard;
import com.lt.constants.Grade;
import com.lt.utils.DBUtil;

public class GradeCardDAOImpl implements GradeCardDAOInterface
{
private static volatile GradeCardDAOImpl instance = null;
	
	private GradeCardDAOImpl()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static GradeCardDAOImpl getInstance()
    {
    if(instance == null)
    {
    synchronized(GradeCardDAOImpl.class){
    instance = new GradeCardDAOImpl();
    }
    }
    return instance;
    }

	

	Grade grade;

	@Override
	public List<GradeCard> viewGradeCard(int studentId) 
	{
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		
		List<GradeCard> gradeList = new ArrayList<>();
		try
		{
			
			connection = DBUtil.getConnection();
			
			String str = "select student_id, course_code, course_name, grade from grade where student_id = ?";
			
			preparedStatement = connection.prepareStatement(str);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int student_Id = resultSet.getInt("student_id");
				String courseCode = resultSet.getString("course_code");
				String courseName = resultSet.getString("course_name");
				String grade = resultSet.getString("grade");
				GradeCard obj = new GradeCard(student_Id, courseCode, courseName,grade);
				gradeList.add(obj);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return gradeList;
	}
}