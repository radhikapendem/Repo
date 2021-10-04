package com.lt.business;

 

import org.springframework.stereotype.Service;

import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotAddedException;


/**
 * 
 * @author G4-FullStackGroup
 * Interface for Admin Operations
 * 
 */

public interface AdminInterface 
{
    
    /**
     * Method to add Professor to DB
     * @param professor : Professor Object storing details of a professor
     */
    public boolean addProfessor(String profName, String name,String password, String department, String address) throws ProfessorNotAddedException;
    
    /**
     * Method to approve a Student 
     * @param studentId
     * @return 
     * @throws StudentNotFoundException 
     */
    public boolean approveStudent(int studentId);
    
    /**
     * Method to add Course from Course Catalog
     * @param course : Course object storing details of a course
     * @throws CourseFoundException 
     */
    public boolean addCourses(String courseCode) throws CourseFoundException;
    
    /**
     * Method to Delete Course from Course 
     * @param courseCode
     * @throws CourseNotFoundException 
     */
    public boolean deleteCourses(String courseCode) throws CourseNotFoundException;
    
    /**
     * Method to view Course from catalog 
     */
    public void viewCourseCatalog();
}