package com.lt.rest;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lt.bean.Course;
import com.lt.bean.GradeCard;
import com.lt.bean.Grades;
import com.lt.bean.Professor;
import com.lt.bean.RegisteredCourse;
import com.lt.bean.Student;
import com.lt.business.GradeCardImplService;
import com.lt.business.GradeCardInterface;
import com.lt.business.ProfessorImplService;
import com.lt.business.ProfessorInterface;
import com.lt.business.RegisteredCourseImplService;
import com.lt.business.RegisteredCourseInterface;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeNotAddedException;

/*
 * @author G4-FullStackGroup
 * Annotation for permitting cross-origin requests on specific handler
 * classesand/or handler methods. Processed if an appropriate HandlerMappingis configured.
 */
@CrossOrigin

/*
 * A convenience annotation that is itself annotated with @Controller and @ResponseBody.
 */
@RestController

/*
 * Annotation for mapping web requests onto methods in request-handling Professor classes with
 * flexible method signatures.
 */
@RequestMapping("/Professor")
/**
 * Class that display Professor Menu
 */
public class ProfessorRestApi {

	/*
	 * This is the central class in the log4j package. Most loggingoperations,
	 * except configuration, are done through this class
	 */
	private static Logger logger = Logger.getLogger(ProfessorRestApi.class);
	/*
	 * Interface for Professor Operations
	 */
	ProfessorInterface professorInterface=ProfessorImplService.getInstance();
	RegisteredCourseInterface regCourse = RegisteredCourseImplService.getInstance();
	GradeCardInterface gradeCard = GradeCardImplService.getInstance();

	/*
	 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
	 * A Method declaration for viewRegisteredCourses
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value ="/viewRegisteredCourses")
	public List<RegisteredCourse> viewRegisteredCourses(@RequestBody Student student) throws CourseNotFoundException{
		return regCourse.viewRegCourses(student.getStudentId());
	}

	/*
	 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
	 * A Method declaration for addGradeCard
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value ="/addGradeCard")
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public Response viewGradeCard(@RequestBody Grades grade) throws GradeNotAddedException{
		if(professorInterface.addGrade(grade.getCourseId(), grade.getCourseName(), grade.getGrade(), grade.getStudentId()))
		{
			logger.info("Grade added successfully!");
			return Response.status(201).entity("Grade added successfully! ").build();
		}
		else
		{
			logger.error("Something went wrong, please retry!!");
			return Response.status(500).entity("Something Went wrong!").build();
		}
	}

	/*
	 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures.
	 * A Method declaration for viewCourses
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value ="/viewCourses")
	public Response getCourses() throws CourseNotFoundException{
		if(professorInterface.getCourses().size()!=0) {
			logger.info("Courses displayed successfully!!");
			return Response.status(201).entity("Courses displayed successfully! ").build();
		}
		else
		{
			logger.error("No course found! ");
			return Response.status(500).entity("No course found!").build();
		}
	}

}