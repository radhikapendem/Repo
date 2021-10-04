package com.lt.bean;

import org.springframework.stereotype.Component;

/**
 * 
 * @author G4-FullStackGroup
 * User Class
 * 
 */
@Component
public class User {


	private String Username;
	private String Password;
	private int RoleId;

	public User() {}

	/**
	 *Parametrised Constructor
	 * @return values
	 */
	public User(String username, String password, int roleId) {
		super();
		Username = username;
		Password = password;
		RoleId = roleId;
	}

	public User(String username, String password) {
		super();
		Username = username;
		Password = password;
	}


	/**
	 * Method to get Username
	 * @param getUsername
	 */
	public String getUsername() {
		return Username;
	}
	/**
	 * Method to set User name
	 * @param setUsername
	 */
	public void setUsername(String username) {
		Username = username;
	}
	/**
	 * Method to get Password
	 * @param getPassword
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * Method to get Password
	 * @param getPassword
	 */
	public void setPassword(String password) {
		Password = password;
	}
	/**
	 * Method to get RoleId
	 * @param getRoleId
	 */
	public int getRoleId() {
		return RoleId;
	}
	/**
	 * Method to set RoleId
	 * @param setRoleId
	 */
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}

}	