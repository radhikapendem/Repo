package com.lt.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.exception.StudentNotRegisteredException;
import com.lt.exception.UserNotFoundException;
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
 * Annotation for mapping web requests onto methods in request-handling User classes with
 * flexible method signatures.
 */
@RequestMapping("/User")

/**
 * Class that display UserRestApi Menu
 */
public class UserRestApi {
	/*
	 * This is the central class in the log4j package. Most loggingoperations,
	 * except configuration, are done through this class
	 */
	private static Logger logger = Logger.getLogger(UserRestApi.class);
	/*
	 * Interface for userInterface Operations
	 */
	UserInterface userInterface= UserImplService.getInstance();

	/*
	 * Marks a constructor, field, setter method, or config method as to be
	 * autowired bySpring's dependency injection facilities. This is an alternative
	 * to the JSR-330 javax.inject.Inject annotation, adding required-vs-optional semantics.
	 */
	@Autowired
	StudentInterface studentInterface;

	/**
	 * A Method declaration for update Password
	 * @param userId: email address of the user
	 * @param newPassword: new password to be stored in db.
	 * @return 201, if password is updated, else 500 in case of error
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
	/*
	 * Marks a method or exception class with the status code and reason that should be returned.
	 */
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	/*
	 * Supported for annotated handler methods.
	 */
	public Response passwordUpdate(@RequestBody User user){

		if(userInterface.updatePassword(user.getUsername(),user.getPassword())) { // Method to get Username
			return Response.status(201).entity("Password updated successfully! ").build();
		}
		else {
			return Response.status(500).entity("Something went wrong, please try again!").build();
		}

	}

	/*
	 * The status code is applied to the HTTP response when the handlermethod is invoked
	 * and overrides status information set by other means,like ResponseEntity or "redirect:".
	 * Marks a method or exception class with the status code and reason that should be returned.
	 */
//	@ResponseStatus(HttpStatus.NOT_FOUND)
	/*
	 * A method declaration for login
	 * Supported for annotated handler methods.
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
    public Response login(@PathVariable String username, @PathVariable String password) throws Exception
    {
 
        try
        {
            boolean isloggedin=userInterface.login(username,password);
            int roleId = userInterface.getRole(username);
            if(isloggedin)
            {
                switch(roleId)
                {
                case 1:
                    int studentId=studentInterface.getStudentId(username);
                    boolean isApproved=studentInterface.isApproved(studentId);
                    if(!isApproved)
                    {
                         logger.warn("Failed to login, wait for Admin approval");
                        return Response.status(200).entity("Login unsuccessful! Student "+username+" has not been approved by the administration!" ).build();
                    }
                    break;
                }
                return Response.status(200).entity("Login successful").build();
            }
            else
            {
                logger.error("Invalid Credentials!");
                return Response.status(500).entity("Invalid credentials!").build();
            }
        }
        catch (UserNotFoundException ex)
        {
            logger.error(ex.getUserId()+" not registered!");
            return Response.status(500).entity(ex.getMessage()).build();
 
        }
    }
	/**
	 * A method declaration for studentRegistration
	 * @param student
	 * @return 201, if user is created, else 500 in case of error
	 */
	//@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/studentRegistration")
	
	public Response singup(@RequestBody Student student) throws Exception{
		try {
			studentInterface.signup(student.getStudentName(), student.getPassword(), student.getStudentContactNo(),
					student.getStudentEmailId(), student.getStudentAddress(), student.getBranch());
		}
		catch(StudentNotRegisteredException ex)
		{
			logger.error("Something went wrong! "+ex.getStudentName() +" not registered. Please try again");
			return Response.status(500).entity("Something went wrong! Please try again.").build();
		}
		return Response.status(201).entity("Registration Successful for "+student.getStudentName()).build();
	}

	/**
	 * A method declaration for getRole
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	@RequestMapping(value = "/getRole/{username}", method = RequestMethod.GET)
	public int getRole(@PathVariable String username ) throws Exception{
		return userInterface.getRole(username);
	}

}