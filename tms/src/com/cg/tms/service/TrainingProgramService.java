package com.cg.tms.service;



import java.util.Map;
import java.util.Set;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.beans.Program;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public interface TrainingProgramService {

	/**
	 * @throws DatabaseWriteException 
	 * @throws ProgramException 
	 * 
	 */
	public boolean createProgram(Program trainingProgram) throws ProgramException;

	/**
	 * @throws DatabaseWriteException 
	 * @throws TrainingProgramNotFoundException 
	 * @throws ProgramException 
	 * @throws CourseNotFoundException 
	 * 
	 */
	public boolean deleteTrainingProgram(String trainingId) throws ProgramException;

	public boolean modifyTrainingProgram(Program trainingProgram);
	
	public Program retrieveTrainingProgram(String trainingId) throws ProgramException;
	
	public Set<Program> retrieveAllTrainingProgram() throws ProgramException;

	

}