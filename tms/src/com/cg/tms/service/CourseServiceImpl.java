package com.cg.tms.service;

import java.util.*;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.dao.CourseServiceDaoImpl;
import com.cg.tms.dao.CrudService;
import com.cg.tms.entity.Course;

/**
 * 
 */
public class CourseServiceImpl implements CourseService {
	CrudService<Course> crudOperation = new CourseServiceDaoImpl();
	
	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Course> getAllCourse() throws DatabaseWriteException {
		return crudOperation.retrieveAll();
	}

	@Override
	public Course getCourseDetails(final String courseId) throws DatabaseWriteException, CourseNotFoundException, TrainingProgramNotFoundException {
		Course course = crudOperation.retrieve(courseId);

		return course;
	}

}