package com.cg.tms.service;

import java.util.*;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.entity.Course;

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
	 * 
	 */
	public Set<Course> getAllCourse() throws DatabaseWriteException;

	/**
	 * @throws DatabaseWriteException
	 * @throws CourseNotFoundException 
	 * @throws TrainingProgramNotFoundException 
	 * 
	 */
	public Course getCourseDetails(String courseId) throws DatabaseWriteException, CourseNotFoundException, TrainingProgramNotFoundException;

}