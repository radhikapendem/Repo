package com.lt.rest;

import java.sql.SQLException;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lt.bean.Catlog;
import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.AdminImplService;
import com.lt.business.AdminInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.dao.AdminDAOImpl;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotAddedException;
import com.lt.exception.StudentNotFoundException;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
/*
 * Annotation for permitting cross-origin requests on specific handler
 * classesand/or handler methods. Processed if an appropriate HandlerMappingis configured.
 *
 */
@RestController
/*
 * A convenience annotation that is itself annotated with @Controller and @ResponseBody.
 *
 */
@RequestMapping("/Admin")
/*
 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
 */

/**
 *
 * @author G4-FullStackGroup
 * Class for AdminRestApi
 *
 */
@Controller
public class AdminRestApi
{
	/*
	 * This is the central class in the log4j package. Most loggin goperations, except configuration, are done through this class.
	 */
	private static Logger logger = Logger.getLogger(UserRestApi.class);
	
	@Autowired
	AdminInterface adminInterace;
	@Autowired
	UserInterface userInterface;
	

	/*
	 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
	 */
	@RequestMapping(value = "/approveStudent", method = RequestMethod.POST)
	/*
	 * Marks a method or exception class with the status code and reason that should be returned.
	 *
	 * A method declaration for approve Student
	 */
	
	public Response approveStudent(@RequestBody Student student) throws StudentNotFoundException
	{
		if(adminInterace.approveStudent(student.getStudentId()))
		{
			logger.info("student approved Successfully.");
			return Response.status(201).entity("Student approved successfully! ").build();
		}
		else
		{
			logger.warn("Student has been already approved or studentID not found");
			return Response.status(500).entity("Student has been already approved or studentID not found ").build();
		}
	}
	/*
	 * a controller class may also be annotated with @ResponseStatus which is then inherited
	 * by all @RequestMapping and @ExceptionHandler methods in that class and its subclasses
	 * unlessoverridden by a local @ResponseStatus declaration on the method.
	 *
	 * A method declaration for add professor and throws SQLException
	 */
	@RequestMapping(value = "/addProfessor", method = RequestMethod.POST)
	//@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public Response addProfessor(@RequestBody Professor professor) throws ProfessorNotAddedException
	{
		if(adminInterace.addProfessor(professor.getProfessorName(),professor.getUsername(),professor.getPassword(),professor.getDepartment(),professor.getProfessorAddress()))
		{
			logger.info("Professor added Successfully.");
			return Response.status(201).entity("Professor added successfully! ").build();
		}
		else
		{
			logger.warn("professor is already added!!!");
			return Response.status(500).entity("professor is already added!").build();
		}
	}
	/*
	 * A method declaration for addCourse and throws CourseFoundException
	 */
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	
	public Response addCourse(@RequestBody Catlog catlog) throws CourseFoundException
	{
		if(adminInterace.addCourses(catlog.getCourseCode()))
		{
			logger.info("Course added Successfully.");
			return Response.status(201).entity("Course added successfully! ").build();
		}
		else
		{
			logger.warn("Course is already present!!!!");
			return Response.status(500).entity("Course is already present!!!").build();
		}
		
	}
	/*
	 * A method declaration for delete Course and throws CourseNotFoundException
	 */
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.DELETE)
	
	public Response deleteCourse(@RequestBody Course course ) throws CourseNotFoundException
	{
		if(adminInterace.deleteCourses(course.getCourseCode()))
		{
			logger.info("Course deleted Successfully.");
			return Response.status(201).entity("Course deleted successfully! ").build();
		}
		else
		{
			logger.error("Incorrect CourseCode!!");
			return Response.status(500).entity("Incorrect CourseCode!!!").build();
		}
	}
}