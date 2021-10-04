package com.lt.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lt.bean.User;

public interface UserDAOInterface 
{	
	public boolean signupUser(String username,String password, int role);
	public boolean verifyCredential(String username, String password) throws Exception;
	public boolean updateUserPassword(String username, String password);
	int getRole(String userId) throws SQLException;
	List<User> getUserCredential();
}
