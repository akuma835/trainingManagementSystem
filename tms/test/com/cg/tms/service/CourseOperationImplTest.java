package com.cg.tms.service;

import static org.junit.Assert.*;

import java.util.InputMismatchException;
import java.util.List;

import org.junit.Before;

import org.junit.Test;

import com.cg.exception.DatabaseWriteException;
import com.cg.tms.beans.Course;
import com.cg.tms.dao.DatabaseCollection;
import com.cg.tms.service.CourseService;
import com.cg.tms.service.CourseServiceImpl;

public class CourseOperationImplTest {
	List<Course> courseList;
	CourseService courseOperation = new CourseServiceImpl();
//	DatabaseCollection database = new DatabaseCollection();

	@Before
	public void initializeDB() {
		DatabaseCollection.initiateDB();
	}

	@Test()
	public void retrieveCourseTest() throws DatabaseWriteException,InputMismatchException {
		assertNotNull( courseOperation.getAllCourse());
	}
	



}
