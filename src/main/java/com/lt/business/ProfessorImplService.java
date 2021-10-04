package com.lt.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;
import com.lt.dao.ProfessorDAOImpl;
import com.lt.dao.ProfessorDAOInterface;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeNotAddedException;
@Service
public class ProfessorImplService implements ProfessorInterface {

	
    ProfessorDAOImpl professorDAOInterface=ProfessorDAOImpl.getInstance();
	
	private static volatile ProfessorImplService instance = null;
	
	private ProfessorImplService()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static ProfessorImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(ProfessorImplService.class){
    instance = new ProfessorImplService();
    }
    }
    return instance;
    }
    
//	private ProfessorImplService()
//	{
//
//	}
	/**
	 * Method to grade a Student
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 * @return boolean indicating if grade is added or not
	 * @throws GradeNotAddedException
	 */
	@Override
	public boolean addGrade(String courseCode, String courseName, String grade,int studentId) throws GradeNotAddedException {
		try
		{
			professorDAOInterface.addGrade(courseCode, courseName, grade,studentId);
		}
		catch(Exception ex)
		{
			throw new GradeNotAddedException(studentId);
		}
		return true;
	}
	
	
	/**
	 * Method to view all the enrolled students
	 * @param profId: professor id 
	 * @return List of enrolled students
	 */
	@Override
	public boolean getRegisteredCourses(String profId) throws SQLException{
		boolean studentsCount = false;
		try
		{
			if(professorDAOInterface.getRegisteredCourses(profId)) {
				studentsCount = true;
			}
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return studentsCount;
	}

	
	/**
	 * Method to get list of all course a professor is teaching
	 * @param profId: professor id 
	 * @return List of courses the professor is teaching
	 */
	@Override
	public List<Course> getCourses() throws CourseNotFoundException
	{
		//call the DAO class
		//get the courses for the professor
		List<Course> coursesOffered=new ArrayList<Course>();
		try
		{
			coursesOffered=professorDAOInterface.getCoursesByProfessor();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw ex;
		}
		return coursesOffered;
	}
	
	/**
	 * Method to get the professor name with ID
	 * @param profId
	 * @return Professor name 
	 */
	@Override
	public String getProfessorById(String profId)
	{
		return professorDAOInterface.getProfessorById(profId);
	}
}
