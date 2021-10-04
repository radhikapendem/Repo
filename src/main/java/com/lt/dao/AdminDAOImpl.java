package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.lt.bean.Admin;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
import com.lt.utils.DBUtil;

/**
 * @author G4-FullStackGroup
 * Dao Class Operations for Admin
 * 
 */
@Repository
public class AdminDAOImpl implements AdminDAOInterface
{
	private static volatile AdminDAOImpl instance = null;
	
	private static Logger logger = Logger.getLogger(AdminDAOImpl.class);

	public AdminDAOImpl(){

	}


	/**
	 * Method to make AdminOperation Singleton
	 * @return
	 */


	public static AdminDAOImpl getInstance()
	{
		if(instance==null)
		{
			synchronized(AdminDAOImpl.class) {
				instance=new AdminDAOImpl();
			}
		}
			return instance;
		}
	
	static List<Admin> adminList= new ArrayList<Admin>();
	/*
	 * @Override public List<Admin> getAdminCredential() { Connection conn =
	 * DBUtils.getConnection(); try { String adminname =""; String password="";
	 * String str = "select * from admin"; PreparedStatement myStmt =
	 * conn.prepareStatement(str); ResultSet myRs = myStmt.executeQuery();
	 * 
	 * myRs.next();
	 * 
	 * adminname = myRs.getString(1); password = myRs.getString(2);
	 * adminList.add(new Admin(adminname,password)); } catch (SQLException ex) {
	 * logger.info("Exception occurred...."); } finally { try { conn.close();
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * } return adminList; }
	 */

	/**
	 * Approve Student using SQL commands
	 * @param studentName
	 * @throws StudentNotFoundException
	 */
	@Override
	public boolean adminApproval(int studentId) 
	{

		Connection conn = DBUtil.getConnection();
		try 
		{
			String str = "update student set isapproved = 1 where student_id = ?";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setInt(1, studentId);
			int row = myStmt.executeUpdate();	
			if(row==1)
				return true;
			else
				return false;
		} 
		catch (SQLException ex) 
		{
			logger.info("Exception occurred....");
		} 
		return false;
	}


	/**
	 * Add Course using SQL commands
	 * @param courseId,courseName
	 * @throws CourseFoundException
	 */
	@Override
	public boolean addCourse(String courseCode, String courseName, double courseFee) throws CourseFoundException
	{

		Connection conn = DBUtil.getConnection();
		try 
		{
			String str = "insert into course(course_code,course_name,prof_id,seats,course_fee) values (?,?,?,?,?)";
			PreparedStatement myStmt = conn.prepareStatement(str);
			
			myStmt.setString(1, courseCode);
			myStmt.setString(2,courseName);
			myStmt.setString(3,null);
			myStmt.setString(4,null);
			myStmt.setDouble(5, courseFee);
			int row = myStmt.executeUpdate();
			
			
			if(row==1)
				return true;
			else
				return false;
		} 
		catch (SQLException ex) 
		{
			
			System.out.println("Exception occurred....");
		} 

		return false;
	}

	/**
	 * Delete Course using SQL commands
	 * @param courseId, courseName
	 * @throws CourseNotFoundException
	 */
	@Override
	public boolean deleteCourse(String courseId, String courseName) throws CourseNotFoundException
	{

        Connection conn = DBUtil.getConnection();
        try
        {
            String str = "delete from course where course_code=?";
            PreparedStatement myStmt = conn.prepareStatement(str);
            myStmt.setString(1, courseId);
           
            int check=myStmt.executeUpdate();
            if(check == 1)
            {
                 return true;
            }
            else
            {
            return false;
            }
        }
        catch (SQLException ex)
        {
            logger.error("Exception occurred....");
        }
        catch(Exception e)
        {
            logger.error("Something went wrong!!!");
        }
           
        return false;
       	 
	}
}
