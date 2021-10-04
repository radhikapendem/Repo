package com.lt.business;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.lt.dao.SemesterRegistrationDAOImpl;
@Service
public class SemesterRegistrationImplService implements SemesterRegistrationInterface 
{
	static int counter=100;

	public void semesterMenu() 
	{
		PaymentInterface pi = PaymentImplService.getInstance();
		SemesterRegistrationDAOImpl sm = SemesterRegistrationDAOImpl.getInstance();
		RegisteredCourseInterface rm= RegisteredCourseImplService.getInstance();


		if(sm.getRegisteredStudentById(counter))
		{
			counter++;
		}
		System.out.println("Your studentID is:"+" "+ counter);
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student Name: ");
		String stdName = in.next();
		System.out.println("Choose the Semester:-");
		System.out.println("1. Semester-1"+"\n"+"2. Semester-2"+"\n"+"3. Semester-3"+"\n"+"4. Semester-4"+"\n"+"5. Exit");
		int selection = in.nextInt();


		switch(selection)
		{
		case 1: System.out.println("Semester-1:-");
		if(rm.getStudentDetails(counter, stdName, selection))
		{
			sm.getSemFee(selection);
			//			pi.getPayment();  
		}
		break;

		case 2: System.out.println("Semester-2:-");
		if(rm.getStudentDetails(counter, stdName, selection))
		{
			sm.getSemFee(selection);
			//			pi.getPayment();  
		}
		break;


		case 3: System.out.println("Semester-3:-");
		if(rm.getStudentDetails(counter, stdName, selection))
		{
			sm.getSemFee(selection);
			//			pi.getPayment();  
		}
		break;


		case 4: System.out.println("Semester-4:-");
		if(rm.getStudentDetails(counter, stdName, selection))
		{
			sm.getSemFee(selection);
			//			pi.getPayment();  
		}
		break;


		case 5: System.out.println("Exit");
		break;

		}
	}


	//	@Override
	//	public String addCourse() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//	@Override
	//	public String dropCourse() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//	@Override
	//	public String paymentStatus() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}


}

