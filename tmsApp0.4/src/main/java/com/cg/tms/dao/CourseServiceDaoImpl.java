package com.cg.tms.dao;
import java.util.*;

import com.cg.tms.entity.Course;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;


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
	public Course retrieve(int courseId) throws ProgramException {

		Set<Course> courses;
		courses=retrieveAll();
		Course course=null;
		for (Course c : courses) {
			if (courseId==(c.getCourseId())) {
				course=c;
			}
		}
		if (course==null)
			throw new ProgramException(ErrorMessages.MESSAGE7);
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