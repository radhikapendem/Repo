package com.lt.rest;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Course;
import com.lt.bean.EnrolledStudent;
import com.lt.bean.GradeCard;
import com.lt.bean.RegisteredCourse;
import com.lt.bean.Student;
import com.lt.business.CourseImplService;
import com.lt.business.CourseInterface;
import com.lt.business.GradeCardImplService;
import com.lt.business.GradeCardInterface;
import com.lt.business.PaymentImplService;
import com.lt.business.PaymentInterface;
import com.lt.business.RegisteredCourseImplService;
import com.lt.business.RegisteredCourseInterface;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.dao.CoursecatalogDAOImpl;
import com.lt.dao.CoursecatalogDAOInterface;
import com.lt.dao.PaymentDAOImpl;
import com.lt.dao.PaymentDAOInterface;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.StudentDAOInterface;
import com.lt.exception.CourseLimitExceedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeCardNotFoundException;
import com.lt.exception.PaymentNotSuccessfull;
import com.lt.exception.UserNotApprovedException;

/*
 * @author G4-FullStackGroup
 * Annotation for permitting cross-origin requests on specific handler
 * classesand/or handler methods. Processed if an appropriate HandlerMappingis configured.
 */
@CrossOrigin(origins = {"*"})

/*
 * A convenience annotation that is itself annotated with @Controller and @ResponseBody.
 */
@RestController

/*
 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
 */
@RequestMapping("/Student")

/**
 * Class that display StudentRestApi Menu
 */
public class StudentRestApi {

	/*
	 * This is the central class in the log4j package. Most loggingoperations,
	 * except configuration, are done through this class
	 */
	private static Logger logger = Logger.getLogger(UserRestApi.class);

	/*
	 * Interface for StudentInterface Operations
	 */
	StudentInterface student = new StudentImplService();

	GradeCardInterface gradeCard = GradeCardImplService.getInstance();
	RegisteredCourseInterface regCourse = RegisteredCourseImplService.getInstance();
	CourseInterface course = CourseImplService.getInstance();
	CoursecatalogDAOInterface daoCourseCatalog = CoursecatalogDAOImpl.getInstance();
	PaymentInterface payment = PaymentImplService.getInstance();
	PaymentDAOInterface daoPayment = PaymentDAOImpl.getInstance();
	StudentDAOInterface daoStudent =StudentDAOImpl.getInstance();

	/*
	 * Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.
	 * A Method declaration for doPayment
	 */
	@RequestMapping(value = "/doPayment", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
	public Response doPayment(@RequestBody Student student) throws PaymentNotSuccessfull {

		if(payment.calculateFee(student.getStudentId())!=0) {
			logger.info("Payment Done Sucessfully......");
			return Response.status(201).entity("Payment Done Sucessfully! ").build();
		}
		else
		{
			logger.warn("Something went wrong, please retry!!");
			return Response.status(500).entity("Something went wrong, please retry!!").build();
		}
	}

	/*
	 * Marks a method or exception class with the status code and reason that should be returned.
	 * A Method declaration for registerCourse
	 */
	//@ResponseStatus(HttpStatus.FORBIDDEN)
	@RequestMapping(method = RequestMethod.POST, value = "/registerCourse/{studentId}/{courseCode}")
	public ResponseEntity registerCourse(@PathVariable int studentId, @PathVariable String courseCode) throws CourseLimitExceedException, CourseNotFoundException, UserNotApprovedException {

		if(student.isApproved(studentId) == false) {

			logger.warn("Student is not Approved by the Admin.");
			
			return new ResponseEntity<>("Student is not Approved by the Admin.", HttpStatus.CONFLICT);
		}
		else if(regCourse.regCourse(courseCode,studentId)) {
			logger.info("Payment Done Sucessfully......");
			
			return new ResponseEntity<>("Student course registration is Sucessfull.", HttpStatus.OK);
		}
		else {
			throw new CourseNotFoundException(courseCode);
		}
	}

	/*
	 * Marks a method or exception class with the status code and reason that should be returned.
	 * A Method declaration for dropCourse
	 * @throws CourseNotFoundException
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
//	@ResponseStatus(HttpStatus.NOT_FOUND)
	@RequestMapping(method = RequestMethod.DELETE, value = "/dropCourse/{studentId}/{courseCode}")
	public ResponseEntity dropCources(@PathVariable int studentId, @PathVariable String courseCode) throws CourseNotFoundException,UserNotApprovedException {
		List<RegisteredCourse> registeredCourseList = regCourse.viewRegCourses(studentId);

		if(student.isApproved(studentId) == false) {
			logger.warn("Student is not Approved by the Admin.");
			return new ResponseEntity<>("Student is not Approved by the Admin.", HttpStatus.CONFLICT);
		}
		else if(regCourse.dropCourse(courseCode, studentId, registeredCourseList)){
			return new ResponseEntity<>("Course Drop is Successfull for "+studentId, HttpStatus.OK);
		}
		else {
			throw new CourseNotFoundException(courseCode);
			
		}
		
	}

	/*
	 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
	 * A Method declaration for dropCourse
	 * @PathVariable studentId
	 * @throws SQLException
	 */
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value ="/viewRegisteredCourses/{studentId}")
	public List<RegisteredCourse> viewRegisteredCourses(@PathVariable int studentId) throws CourseNotFoundException
	{
		logger.info("Course Displayed Successfully.");
		return regCourse.viewRegCourses(studentId);
	}

	/*
	 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
	 * A Method declaration for viewGradeCard
	 * @PathVariable studentId
	 * @throws SQLException
	 */
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	@ResponseBody()
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value ="/viewGradeCard/{studentId}")
	public List<GradeCard> viewGradeCard(@PathVariable int studentId) throws GradeCardNotFoundException{
		logger.info("Grade Displayed Successfully.");
		return gradeCard.viewGradeCard(studentId);
	}

	/*
	 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
	 * A Method declaration for viewAvailableCourses
	 * @throws SQLException
	 */
//	@ResponseStatus(HttpStatus.NOT_FOUND)
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value ="/viewAvailableCourses")
	public List<Course> viewCourses() throws CourseNotFoundException{
		logger.info("Course Displayed Successfully.");
		return course.viewCourses();
	}
}