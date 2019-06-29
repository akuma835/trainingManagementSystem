package com.cg.tms.service;

import java.util.*;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.beans.Course;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public interface CourseService {

	/**
	 * 
	 */
	public boolean addCourse(Course course);

	/**
	 * 
	 */
	public boolean deleteCourse(Course course);

	/**
	 * 
	 */
	public boolean modifyCourse(Course course);

	/**
	 * @throws DatabaseWriteException
	 * @throws ProgramException 
	 * @throws CourseNotFoundException 
	 * 
	 */
	public Set<Course> getAllCourse() throws ProgramException;

	/**
	 * @throws DatabaseWriteException
	 * @throws CourseNotFoundException 
	 * @throws TrainingProgramNotFoundException 
	 * @throws ProgramException 
	 * 
	 */
	public Course getCourseDetails(String courseId) throws ProgramException;

}