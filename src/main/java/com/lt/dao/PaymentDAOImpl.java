package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lt.constants.PaymentMode;
import com.lt.utils.DBUtil;

public class PaymentDAOImpl implements PaymentDAOInterface
{

private static volatile PaymentDAOImpl instance = null;
	
	private PaymentDAOImpl()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static PaymentDAOImpl getInstance()
    {
    if(instance == null)
    {
    synchronized(PaymentDAOImpl.class){
    instance = new PaymentDAOImpl();
    }
    }
    return instance;
    }

	
	@Override
	public double calculateFee(int studentId) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		double fee = 0;
		try
		{
			connection=DBUtil.getConnection();
			String query = "select sum(course_fee) from registered_course where student_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			fee = resultSet.getDouble(1);
		}
		catch(SQLException e)
		{
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return fee;
	}

	@Override
	public boolean payment(int studentId, PaymentMode mode, double fee) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try
		{
			connection=DBUtil.getConnection();
			String query = "insert into payment(student_id, mode, amount, status) values(?,?,?,?);";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setString(2, mode.toString());
			preparedStatement.setDouble(3, fee);
			preparedStatement.setString(4, "paid");
			int row = preparedStatement.executeUpdate();
			
			if(row==1)
				return true;
			else
				return false;
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;


	}
	
	@Override
	public String paymentStatus(int studentId) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		String status = null;
		try
		{
			connection=DBUtil.getConnection();
			String query = "select status from payment where student_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			status = resultSet.getString("status");
		}
		catch(SQLException e)
		{
//			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return status;
	}

}
