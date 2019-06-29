package com.cg.tms.service;

import java.util.Set;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.beans.Course;
import com.cg.tms.beans.Program;
import com.cg.tms.dao.CourseServiceDaoImpl;
import com.cg.tms.dao.CrudService;
import com.cg.tms.dao.TrainingProgramServiceDaoImpl;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public class TrainingProgramServiceImpl implements TrainingProgramService {
	CrudService<Course> crudOnCourse = new CourseServiceDaoImpl();
	CrudService<Program> crudOnTrainingProgram = new TrainingProgramServiceDaoImpl();

	@Override
	public boolean createProgram(Program trainingProgram) throws ProgramException {
		boolean flag = false;
		flag = crudOnTrainingProgram.create(trainingProgram);
		return flag;
	}

	@Override
	public boolean deleteTrainingProgram(String trainingId) throws ProgramException {
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
			throws ProgramException {
		final Course course = crudOnCourse.retrieve(courseId);
		if (course != null)
			return true;
		else
			return false;

	}

	@Override
	public Program retrieveTrainingProgram(String trainingId)
			throws ProgramException{
		Set<Program> trainingPrograms = retrieveAllTrainingProgram();
		Program program = null;
		for (Program trainingProgram : trainingPrograms) {
			if (trainingProgram.getTrainingId().equals(trainingId)) {
				program = trainingProgram;
				break;
			}
		}
		if (program == null) {
			throw new ProgramException(ErrorMessages.MESSAGE6);
		}
		return program;
	}

	@Override
	public Set<Program> retrieveAllTrainingProgram()
			throws ProgramException{
		Set<Program> trainingPrograms;
		trainingPrograms = crudOnTrainingProgram.retrieveAll();
		return trainingPrograms;
	}

}