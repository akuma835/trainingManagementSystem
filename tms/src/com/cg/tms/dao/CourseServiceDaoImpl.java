package com.cg.tms.dao;

import java.util.*;

import com.cg.exception.CourseNotFoundException;
import com.cg.tms.beans.Course;

/**
 * 
 */
public class CourseServiceDaoImpl implements CrudService<Course> {
	Set<Course> courses = new HashSet<Course>();
	Iterator<Course> courseIterator = courses.iterator();

	@Override
	public boolean create(Course o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Course o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course retrieve(String courseId) throws CourseNotFoundException {

		Set<Course> courses;
		courses=retrieveAll();
		Course course=null;
		for (Course c : courses) {
			if (courseId.equals(c.getCourseId())) {
				course=c;
			}
		}
		if (course==null)
			throw new CourseNotFoundException("Course Not Available");

		return course;
	}

	@Override
	public boolean delete(Course o) {
		// TODO Auto-generated method stub
//		courses.
		return false;
	}

	@Override
	public Set<Course> retrieveAll() {

		courses.addAll(DatabaseCollection.course);
		return courses;
	}

}