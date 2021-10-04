package com.lt.dao;

import java.util.List;

import com.lt.bean.Student;

public interface StudentDAOInterface 
{
	public List<Student> getNotApprovedStudentList();
	public int getStudentId(String userName);
	public boolean signup(Student student) throws Exception;
}
