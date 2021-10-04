package com.lt.constants;
/**
 * 
 * Class storing SQL Queries
 */

public class SQLQueriesConstants {
	//ProfessorDAO Queries
	public static final String GET_COURSES="select course_code,course_name from course";
	public static final String GET_ENROLLED_STUDENTS="select course.courseCode,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where course.professorId in (select professorId from professor where userId = ?) order by course.courseCode";
	public static final String ADD_GRADE="insert into grade (course_code,course_name,grade,student_id) values (?,?,?,?)";
	public static final String GET_PROF_NAME = "select name from user where userId in (select userId from professor where professorId = ?)";
	
}
