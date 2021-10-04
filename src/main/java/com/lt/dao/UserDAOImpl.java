package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lt.bean.User;
import com.lt.utils.DBUtil;

@Repository
public class UserDAOImpl implements UserDAOInterface {
	// method to verify credential instead of business

	//private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	private static volatile UserDAOImpl instance = null;

	public UserDAOImpl()
	{
	}
	/**
	 * Method to make AdminOperation Singleton
	 * @return
	 */
	public static UserDAOImpl getInstance()
	{
		if(instance == null)
		{
			synchronized(UserDAOImpl.class){
				instance = new UserDAOImpl();
			}
		}
		return instance;
	}


	public boolean signupUser(String username, String password, int role) {

		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnection();
			String query = "insert into user(user_name, password, role_id) values (?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, role);
			int row = preparedStatement.executeUpdate();

			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public List<User> getUserCredential() 
	{	
		List<User> userList = new ArrayList<User>();
		Connection conn = DBUtil.getConnection();
		try 
		{
			String str = "select * from user";
			PreparedStatement myStmt = conn.prepareStatement(str);
			ResultSet myRs = myStmt.executeQuery();

			while(myRs.next())
			{
				String username = myRs.getString(1);
				String  password= myRs.getString(2);
				int roleID= myRs.getInt(3);
				userList.add(new User(username,password,roleID));
			}	

			return userList;
		} 
		catch (SQLException ex) 
		{
			System.out.println("Exception occurred....");
		} 

		return userList; 
	}

	@Override
	public boolean verifyCredential(String Username, String password) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try
		{
			connection = DBUtil.getConnection();

			String str = "select password from user where user_name = ?";

			preparedStatement=connection.prepareStatement(str);
			preparedStatement.setString(1,Username);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				if(password.equals(resultSet.getString("password")))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println("Something went wrong, please try again! "+ ex);
		}

		return false; 
	}
	@Override
	public int getRole(String userId) throws SQLException {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try {
			connection=DBUtil.getConnection();
			if(connection != null) {
				//	System.out.println("****connection established-------------");
			}
			String roleId="select role_id from user where user_name = ? ";
			preparedStatement = connection.prepareStatement(roleId);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				return resultSet.getInt("role_id");
			}

		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return 0;
	}

	public boolean updateUserPassword(String username, String newPassword) 
	{

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		try {

			connection=DBUtil.getConnection();

			String str = "update user set password = ? where user_name=?";

			preparedStatement = connection.prepareStatement(str);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, username);

			int row = preparedStatement.executeUpdate();
			if(row==1)
				return true;
			else
				return false;

		} 
		catch (SQLException ex) 
		{

			System.out.println("Exception occurred...."+ex.getMessage());
		}
		return false; 

	}

}
