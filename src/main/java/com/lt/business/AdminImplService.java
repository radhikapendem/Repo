package com.lt.business;

import java.util.Scanner;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lt.bean.Admin;
import com.lt.bean.Catlog;
import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.dao.AdminDAOImpl;
import com.lt.dao.AdminDAOInterface;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.CourseDAOInterface;
import com.lt.dao.CoursecatalogDAOImpl;
import com.lt.dao.CoursecatalogDAOInterface;
import com.lt.dao.ProfessorDAOImpl;
import com.lt.dao.ProfessorDAOInterface;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.StudentDAOInterface;
import com.lt.dao.UserDAOImpl;
import com.lt.dao.UserDAOInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotAddedException;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of Admin Operations
 * 
 */
@Service
public class AdminImplService implements AdminInterface
{
private static volatile AdminImplService instance = null;
    
    private static Logger logger = Logger.getLogger(AdminImplService.class);
    CourseInterface course1 = CourseImplService.getInstance();
    CourseDAOInterface c1= CourseDAOImpl.getInstance();
    UserDAOInterface d1=UserDAOImpl.getInstance();
    ProfessorDAOInterface pi= ProfessorDAOImpl.getInstance();
    AdminDAOInterface adminDao=AdminDAOImpl.getInstance();
    CoursecatalogDAOInterface coursecatalogDAOInterface= CoursecatalogDAOImpl.getInstance();
    
    public AdminImplService()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static AdminImplService getInstance()
    {
        if(instance == null)
        {
            synchronized(AdminImplService.class)
            {
                instance = new AdminImplService();
            }
        }
        return instance;
    }
    
    /**
     * Method to approve a Student 
     * @param studentName
     * @throws StudentNotFoundException 
     */
    @Override
    public boolean approveStudent(int studentId) 
    {
        return adminDao.adminApproval(studentId);
        
    }
    
    /**
     * Method to add professor to user DB
     * @param name,password,contact,emailId,address
     * @throws UserNotAddedException
     */
    @Override
    public boolean addProfessor(String profName, String name, String password, String department, String address) throws ProfessorNotAddedException
    {
        boolean checkProf=true;
        int profRole=2;
        for(User u: d1.getUserCredential())
        {
            if(u.getUsername().equalsIgnoreCase(name))
            {
                 checkProf=false;
                 break;
            }
        }
        if(checkProf)
        {
            if((d1.signupUser(name, password, profRole)) && (pi.signupProfessor(profName, department, address))) 
            {   
            	checkProf=true;
            }
        }
        return checkProf;
    }
    
    /**
     * Method to add Course to Course 
     * @param courseId
     * @throws CourseFoundException
     */
    @Override
    public boolean addCourses(String courseCode) throws CourseFoundException 
    {    
        boolean courseAdded=false;
        for(Catlog catlog : coursecatalogDAOInterface.viewCourses())
        {
            if(courseCode.equals(catlog.getCourseCode()))
            {
                String CourseName=catlog.getCourseName();
                double CourseFee = catlog.getCourseFee();
                if(adminDao.addCourse(courseCode,CourseName,CourseFee))
                {
                    courseAdded=true;
                    break;
                }
            }
        }    
        return courseAdded;
    }
    
    
    /**
     * Method to Delete Course from Course 
     * @param courseId
     * @throws CourseNotFoundException 
     */
    @Override
    public boolean deleteCourses(String courseId) throws CourseNotFoundException 
    {
        boolean checkDelete=false;
        for(Course cc:c1.getCourse())
        {
            if(courseId.equals(cc.getCourseCode()))
            {
                String courseName=cc.getCourseName();
                if(adminDao.deleteCourse(courseId,courseName))
                {
                    checkDelete=true;
                    break;
                }
            }
        }
        return checkDelete;
    }
    
    public void viewCourseCatalog() 
    {
        for(Catlog c:coursecatalogDAOInterface.viewCourses())
        {
                System.out.println(c.getCourseCode()+"         | "+c.getCourseName());
            
        }
    }
}