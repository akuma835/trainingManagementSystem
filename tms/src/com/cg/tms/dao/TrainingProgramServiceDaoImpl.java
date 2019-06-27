package com.cg.tms.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.beans.Program;

public class TrainingProgramServiceDaoImpl implements CrudService<Program> {

	@Override
	public boolean create(Program o) throws DatabaseWriteException {
		boolean flag = false;
		String key = o.getTrainingId();
		if (DatabaseCollection.program.containsKey(key)) {
			throw new DatabaseWriteException("Training Program already exists");
		}
		final Program returnProgramSuccess;
		returnProgramSuccess = DatabaseCollection.program.put(key, o);
		/*
		 * return null means not available in the database and successfully inserted
		 */
		if (returnProgramSuccess == null) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean update(Program o) {
		/* Not yet defined */
		return false;
	}

	@Override
	public Program retrieve(String trainingId) throws DatabaseWriteException {
		Set<Program> programs;
		Program trainingProgram = null;
		programs = retrieveAll();
		for (Program tPrograms : programs) {
			if (tPrograms.getTrainingId().equals(trainingId)) {
				trainingProgram = tPrograms;
				break;
			}
		}
		return trainingProgram;

	}

	@Override
	public boolean delete(Program o) throws TrainingProgramNotFoundException {
		boolean flag = false;
		Program tp = DatabaseCollection.program.remove(o.getTrainingId());
		if (tp != null) {
			flag = true;
		} else {
			throw new TrainingProgramNotFoundException("Training Program Not Found");
		}
		return flag;
	}

	/* Below method will return all the available programs */
	@Override
	public Set<Program> retrieveAll() throws DatabaseWriteException {
		Map<String, Program> map = DatabaseCollection.program;
		if (map == null) {
			throw new DatabaseWriteException("Data not Available in the Database");
		}
		Set<Program> trainingPrograms = new HashSet<Program>();
		for (Program program : map.values()) {
			trainingPrograms.add(program);
		}
		return trainingPrograms;
	}

}