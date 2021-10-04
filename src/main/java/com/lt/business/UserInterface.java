package com.lt.business;


public interface UserInterface {

	public boolean login(String username, String password) throws Exception;
	public boolean updatePassword(String username, String password);
	public String viewRole();
	int getRole(String userId) throws Exception;

}