package com.lt.dao;

import java.util.List;

import com.lt.bean.SemesterRegistration;

public interface SemesterRegistrationDAOInterface 
{ 
	public void getSemFee(int key);
	public List<SemesterRegistration> getRegisteredStudent();
	public boolean getRegisteredStudentById(int studentId);
	public boolean addRegisteredStudent(int studentId, String studentName, int semester);

}
