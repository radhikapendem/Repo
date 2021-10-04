package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.GradeCard;
import com.lt.bean.Student;
import com.lt.exception.UserNotApprovedException;
import com.lt.utils.DBUtil;

public class StudentDAOImpl implements StudentDAOInterface
{	
	public static List<Student> studentList= new ArrayList<Student>();


private static volatile StudentDAOImpl instance = null;
	
	
	
	private StudentDAOImpl()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static StudentDAOImpl getInstance()
    {
    if(instance == null)
    {
    synchronized(StudentDAOImpl.class){
    instance = new StudentDAOImpl();
    }
    }
    return instance;
    }
    
	@Override
	public boolean signup(Student student) throws Exception
	{
		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		try {
			connection=DBUtil.getConnection();
			String query = "insert into student(student_id, name, mail, address, branch_name, user_name, isapproved, contact) values (?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setString(3, student.getStudentEmailId());
			preparedStatement.setString(4, student.getStudentAddress());
			preparedStatement.setString(5, student.getBranch());
			preparedStatement.setString(6, student.getStudentName());
			preparedStatement.setInt(7, 0);
			preparedStatement.setString(8, Long.toString(student.getStudentContactNo()));
			int row = preparedStatement.executeUpdate();
			if(row==1)
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			throw new Exception(ex);
		}
	}

	public  int getStudentId(String userName) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try {
			connection=DBUtil.getConnection();
			if(connection != null) {
				//	System.out.println("****connection established-------------");
			}
			String roleId="select student_id from student where user_name = ? ";
			preparedStatement = connection.prepareStatement(roleId);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				//	System.out.println("****role= "+resultSet.getInt("role_id"));
				return resultSet.getInt("student_id");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return 0;
		
	}

	public  int getStudentCount() {
		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try {
			connection=DBUtil.getConnection();
			String count="select count(*) from student";
			preparedStatement = connection.prepareStatement(count);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return resultSet.getInt("count(*)");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return 0;
		
	}

	@Override
	public List<Student> getNotApprovedStudentList() {
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		
		List<Student> studentList = new ArrayList<>();
		try
		{
			
			connection = DBUtil.getConnection();
			
			String str = "select student_id, name from student where isapproved = 0";
			
			preparedStatement = connection.prepareStatement(str);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int studentId = resultSet.getInt("student_id");
				String studentName = resultSet.getString("name");
				
				Student obj = new Student(studentId, studentName); 
				studentList.add(obj);
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
		
		return studentList;
	}
	

	public boolean isApproved(int studentId) 
	{
		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		try {
			connection=DBUtil.getConnection();
			String roleId="select isapproved from student where student_id = ? ";
			preparedStatement = connection.prepareStatement(roleId);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				if(resultSet.getInt("isapproved") == 0)
					return false;
				else
					return true;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

}
