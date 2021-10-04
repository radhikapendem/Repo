package com.lt.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.UserDAOImpl;
import com.lt.exception.UserNotApprovedException;
import com.lt.rest.UserRestApi;
@Service
public class StudentImplService implements StudentInterface
{	
	private static Logger logger = Logger.getLogger(StudentImplService.class);
	//UserRestApi ura= new UserRestApi();
	
	StudentDAOImpl sDao=StudentDAOImpl.getInstance();
	UserDAOImpl uDao= UserDAOImpl.getInstance();
	GradeCardInterface gradeCard = GradeCardImplService.getInstance();
	CourseDAOImpl courseDAOImpl= CourseDAOImpl.getInstance();
	
	List<String> course = new ArrayList<String>();
	Course cc=new Course();
	List<Course> course1 = new ArrayList<Course>();

	@Override
	public int getStudentId(String userName) {

		return sDao.getStudentId(userName);

	}

	@Override
	public boolean login(String studentName, String studentPassword) 
	{
		boolean isLogin=false;
//		for(User u: uDao.getUserCredential())
//		{
//
//			if((u.getUsername().equals(studentName)) && (u.getPassword().equals(studentPassword)))
//			{
//				System.out.println("Login Successfull"+"\n"); 
//				isLogin=true;
//				break;
//			}				
//		}

		return isLogin;

	}


	@Override
	public String courseSelection() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Select the below options to complete course registeration "); 
		System.out.println("1. Add course"+" \n"+ "2. Drop course"+"\n"+"3. Exit");
		int option = in.nextInt();

		switch(option)
		{

		case 1:	System.out.println("Add course");
		if(addCourse()==true)
		{
			System.out.println("Course added and registered sucessfully");
		}
		break;

		case 2: System.out.println("Drop course");
		if(dropCourse()==true)
		{
			System.out.println("Course has been deleted from your list");
		}
		break;

		case 3:  System.out.println("Exit");
		break;

		}
		return null;
	}

	@Override
	public String payFee() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signup(String username,String password, long contact, String email, String address, String branch) throws Exception
	{	
		boolean isSignup1=true;
//		for(User uc: uDao.getUserCredential())
//		{
//			if(uc.getUsername().equals(username))
//			{
//				System.out.println("Username already exist"+"\n"); 
//				isSignup1=false;
//				break;
//			}
//		} 
		if(isSignup1==true)
		{	
			int studentId = generateStudentId();
			Student student = new Student(studentId, username, email, address, branch, contact);
			sDao.signup(student);
			uDao.signupUser(username, password,1);
			//	uDao.getUserCredential();
			System.out.println("UserProfile is created SucessFully!!! Please login...."+ "\n");
			//crs.login();

		} 
		return isSignup1;

	}

	@Override
	public boolean addCourse() 
	{

		System.out.println("Please select the courseID fromt the below list");

		for (Course c : courseDAOImpl.getCourse()) 
		{
			System.out.println(c.getCourseCode()+" " + c.getCourseName()); 
		}
		for(int i=0; i<6; i++)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter course Id: "); 
			String courseId = in.next();
			System.out.println("Enter course Name: "); 
			String courseName = in.next();
			course1.add(new Course(courseId,courseName));
		}

		return true;

	}

	@Override
	public boolean dropCourse() 
	{
		System.out.println("Please select the courseID fromt the below list");

		for (Course c : course1) 
		{
			System.out.println(c.getCourseCode()+" " + c.getCourseName());  
		}

		Scanner in = new Scanner(System.in);
		System.out.println("Select the courseID to be deleted "); 
		String courseId = in.next();
		System.out.println("Enter course Name: "); 
		String courseName = in.next();

		for (Course c : course1) 
		{
			if(c.getCourseCode()==courseId || c.getCourseName()==courseName)
			{
				course1.remove(c);
				System.out.println("Course has been removed");
				System.out.println(course1);
			}
			else
				continue;	  

		}

		return true;

	}

	@Override
	public String viewGradeCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int generateStudentId() {
		return sDao.getStudentCount()+1;

	}
	
	@Override
	public boolean isApproved(int StudentId) throws UserNotApprovedException
	{
		return sDao.isApproved(StudentId);
		
	}


}
