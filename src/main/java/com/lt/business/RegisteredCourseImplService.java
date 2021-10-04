package com.lt.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.CourseDAOInterface;
import com.lt.dao.RegisteredCourseDAOImpl;
import com.lt.dao.RegisteredCourseDAOInterface;
import com.lt.dao.SemesterRegistrationDAOImpl;
import com.lt.exception.CourseLimitExceedException;
import com.lt.exception.CourseNotFoundException;
@Service
public class RegisteredCourseImplService implements RegisteredCourseInterface
{
	
    private static volatile RegisteredCourseImplService instance = null;
    RegisteredCourseDAOInterface regCourse =RegisteredCourseDAOImpl.getInstance();
	CourseDAOInterface daoCourse =CourseDAOImpl.getInstance();
	
	private RegisteredCourseImplService()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static RegisteredCourseImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(RegisteredCourseImplService.class){
    instance = new RegisteredCourseImplService();
    }
    }
    return instance;
    }

    
	@Override 
	public boolean getStudentDetails(int studentId, String name,int semester) 
	{
		SemesterRegistrationDAOImpl sd= SemesterRegistrationDAOImpl.getInstance();

		boolean isRegistered=false;
		if(!sd.getRegisteredStudentById(studentId)) 
		{
			System.out.println("Student has registered already");
			isRegistered=false; 
		}
		else
		{ 
			sd.addRegisteredStudent(studentId,name,semester); 
			isRegistered=true; 
		}
		return isRegistered;
	}


	@Override
	public String getCourseDetails() 
	{

		return null;
	}

	@Override
	public List<RegisteredCourse> viewRegCourses(int studentId) throws CourseNotFoundException {
		return regCourse.viewRegisteredCourses(studentId);
	}


	@Override
	public boolean addCourse(String courseCode, int studentId, List<Course> courseList, List<RegisteredCourse> registeredCourseList) { 
		
		boolean avail_course = false;
		boolean avail_reg_course = false;
		for(RegisteredCourse course : registeredCourseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseId())) 
			{
				avail_reg_course = true;
			}
		}
		
		for(Course course : courseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseCode())) 
			{
				avail_course = true;
			}
		}
		
		String courseName = daoCourse.getCourseById(courseCode);
		double courseFee = daoCourse.getFeeById(courseCode);
		if(avail_course || !avail_reg_course) {
		return regCourse.addCourses(courseCode, courseName, courseFee, studentId);
		}
		return avail_reg_course;
	}


	@Override
	public boolean dropCourse(String courseCode, int studentId, List<RegisteredCourse> registeredCourseList) {

		boolean avail_reg_course = false;
		for(RegisteredCourse course : registeredCourseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseId())) 
			{
				avail_reg_course = true;
				break;
			}
		}

		if(avail_reg_course) {
			System.out.println("****"+regCourse.dropCourse(courseCode, studentId));
			return regCourse.dropCourse(courseCode, studentId);

		}else {
			System.out.println("Course Code "+courseCode+" not Available...");
		}
		return false;

	}


	@Override
    public boolean regCourse(String courseCode, int studentId) throws CourseLimitExceedException
	{
        double courseFee = 0;
        String courseName = null;
        if(courseCode != null) {
         courseFee = daoCourse.getFeeById(courseCode);
         courseName = daoCourse.getCourseById(courseCode);
        }
        return regCourse.addCourses(courseCode, courseName, courseFee, studentId);  
    }
}
