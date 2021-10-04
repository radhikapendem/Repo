package com.lt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/* Specialization of @Component for classes that declare @ExceptionHandler,
 * @InitBinder, or @ModelAttribute methods to be shared acrossmultiple @Controller classes.
 */
@Controller

/* Specialization of @Component for classes that declare @ExceptionHandler,
 * @InitBinder, or @ModelAttribute methods to be shared acrossmultiple @Controller classes. */
@ControllerAdvice

/**
 *
 * @author G4-FullStackGroup
 * Implementations of GlobalExceptionHandler 
 *
 */
public class GlobalExceptionHandler {

	/*
	 * Annotation for handling exceptions in UserNotFoundException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=UserNotFoundException.class)
	public String handleUserNotFoundException(Model model) {
		model.addAttribute("errMsg", "User not found, please check your details once!");
		return "error";
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	/*
	 * Annotation for handling exceptions in UserNotApprovedException handler classes and/or handler methods.
	 */
	@ExceptionHandler(value=UserNotApprovedException.class)
	public String handleUserNotApprovedException(Model model) {
		model.addAttribute("errMsg", "User not Approved!. please try After some Time!");
		return "error";
	}

	/*
	 * Annotation for handling exceptions in CourseNotFoundException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=CourseNotFoundException.class)
	public String handleCourseNotFoundException(Model model) {
		model.addAttribute("errMsg", "Invalid credentials!. please try After some Time!");
		return "error";
	}

	/*
	 * Annotation for handling exceptions in CourseLimitExceedException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(value=CourseLimitExceedException.class)
	public String handleCourseLimitExceedException(Model model) {
		model.addAttribute("errMsg", "you are exceeded!. please follow the limit !");
		return "error";
	}

	/*
	 * Annotation for handling exceptions in GradeNotAddedException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	@ExceptionHandler(value=GradeNotAddedException.class)
	public String handleGradeNotAddedException(Model model) {
		model.addAttribute("errMsg", "Grade is not added!. please try After some Time!");
		return "error";
	}

	/*
	 * Annotation for handling exceptions in ProfessorNotAddedException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	@ExceptionHandler(value=ProfessorNotAddedException.class)
	public String handleProfessorNotAddedException(Model model) {
		model.addAttribute("errMsg", "Professor not added!. please try After some Time!");
		return "error";
	}

	/*
	 * Annotation for handling exceptions in SeatNotAvailableException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.NOT_EXTENDED)
	@ExceptionHandler(value=SeatNotAvailableException.class)
	public String handleSeatNotAvailableException(Model model) {
		model.addAttribute("errMsg", "All the seats are full !. please try After!");
		return "error";
	}

	/*
	 * Annotation for handling exceptions in StudentNotFoundException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=StudentNotFoundException.class)
	public String handleStudentNotFoundException(Model model) {
		model.addAttribute("errMsg", "student not found!. please try After some time!");
		return "error";
	}

	/*
	 * Annotation for handling exceptions in StudentNotRegisteredException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=StudentNotRegisteredException.class)
	public String handleStudentNotRegisteredException(Model model) {
		model.addAttribute("errMsg", "student not found!. please try After some time!");
		return "error";
	}

	/*
	 * Annotation for handling exceptions in UserNotAddedException handler classes and/orhandler methods.
	 */
	@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
	@ExceptionHandler(value=UserNotAddedException.class)
	public String handleUserNotAddedException(Model model) {
		model.addAttribute("errMsg", "User not found!. please try After some time!");
		return "error";
	}
	
	/*
	* Annotation for handling exceptions in PaymentNotSuccessfull handler classes and/orhandler methods.
	*/
	@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
	@ExceptionHandler(value=PaymentNotSuccessfull.class)
	public String handlePaymentNotSuccessfull(Model model)
	{
		model.addAttribute("errMsg", "Payment not done!. please pay the fee!");
		return "error";
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@ExceptionHandler(value=CourseFoundException.class)
	public String handleCourseFoundException(Model model)
	{
		model.addAttribute("errMsg", "Course has been already addeds");
		return "error";
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=GradeCardNotFoundException.class)
	public String handleGradeCardNotFoundException(Model model)
	{
		model.addAttribute("errMsg", "GradeCard was not found");
		return "error";
	}

}