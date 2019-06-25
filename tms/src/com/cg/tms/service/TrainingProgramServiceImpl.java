package com.cg.tms.service;

import java.util.Set;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.dao.CourseServiceDaoImpl;
import com.cg.tms.dao.CrudService;
import com.cg.tms.dao.TrainingProgramServiceDaoImpl;
import com.cg.tms.entity.Course;
import com.cg.tms.entity.Program;

/**
 * 
 */
public class TrainingProgramServiceImpl implements TrainingProgramService {
	CrudService<Course> crudOnCourse = new CourseServiceDaoImpl();
	CrudService<Program> crudOnTrainingProgram = new TrainingProgramServiceDaoImpl();

	@Override
	public boolean createProgram(Program trainingProgram) throws DatabaseWriteException {
		boolean flag = false;
		flag = crudOnTrainingProgram.create(trainingProgram);
		return flag;
	}

	@Override
	public boolean deleteTrainingProgram(String trainingId)
			throws DatabaseWriteException, TrainingProgramNotFoundException {
		Program program = retrieveTrainingProgram(trainingId);
		if (program == null) {

		}
		crudOnTrainingProgram.delete(program);
		return false;
	}

	@Override
	public boolean modifyTrainingProgram(Program trainingProgram) {
		return false;
	}

	public boolean validateCourse(String courseId)
			throws DatabaseWriteException, CourseNotFoundException, TrainingProgramNotFoundException {
		final Course course = crudOnCourse.retrieve(courseId);
		if (course != null)
			return true;
		else
			return false;

	}

	@Override
	public Program retrieveTrainingProgram(String trainingId)
			throws DatabaseWriteException, TrainingProgramNotFoundException {
		Set<Program> trainingPrograms = retrieveAllTrainingProgram();
		Program program = null;
		for (Program trainingProgram : trainingPrograms) {
			if (trainingProgram.getTrainingId().equals(trainingId)) {
				program = trainingProgram;
				break;
			}
		}
		if (program == null) {
			throw new TrainingProgramNotFoundException("Sorry Training Program not found! Unable to delete");
		}
		return program;
	}

	@Override
	public Set<Program> retrieveAllTrainingProgram() throws DatabaseWriteException {
		Set<Program> trainingPrograms;
		trainingPrograms = crudOnTrainingProgram.retrieveAll();
		return trainingPrograms;
	}

}