package com.cg.tms.service;



import java.util.Map;
import java.util.Set;

import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.entity.Program;

/**
 * 
 */
public interface TrainingProgramService {

	/**
	 * @throws DatabaseWriteException 
	 * 
	 */
	public boolean createProgram(Program trainingProgram) throws DatabaseWriteException;

	/**
	 * @throws DatabaseWriteException 
	 * @throws TrainingProgramNotFoundException 
	 * 
	 */
	public boolean deleteTrainingProgram(String trainingId) throws DatabaseWriteException, TrainingProgramNotFoundException;

	public boolean modifyTrainingProgram(Program trainingProgram);
	
	public Program retrieveTrainingProgram(String trainingId) throws DatabaseWriteException, TrainingProgramNotFoundException;
	
	public Set<Program> retrieveAllTrainingProgram() throws DatabaseWriteException;

	

}