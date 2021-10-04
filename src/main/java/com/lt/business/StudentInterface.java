package com.lt.business;

import com.lt.exception.UserNotApprovedException;

public interface StudentInterface {

	public boolean login(String studentName, String studentPassword);
	public boolean signup(String username,String password, long contact, String email, String address, String branch) throws Exception;
	public String viewGradeCard();
	public String courseSelection();
	public String payFee();
	public boolean addCourse();
	public boolean dropCourse();
	int getStudentId(String userName);
	int generateStudentId();
	boolean isApproved(int StudentId) throws UserNotApprovedException;

}
