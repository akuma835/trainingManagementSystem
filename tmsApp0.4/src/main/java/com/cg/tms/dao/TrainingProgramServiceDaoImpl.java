package com.cg.tms.dao;

import java.util.Set;

import com.cg.tms.entity.Program;
import com.cg.tms.exception.ProgramException;

/*Dao implementation class for Training Program management
 * */
public class TrainingProgramServiceDaoImpl implements CrudService<Program> {
	/* Constructor for initializing the Connection object */
	/***
	 * 
	 * / /* create method takes a program object and extract the value as courseId,
	 * trainerId, centerId, startDate and insert the program in databases
	 */
	@Override
	public boolean create(final Program program) throws ProgramException {
//		
		return true;
	}

	@Override
	public boolean update(final Program program) {
		/* Not yet defined */
		return false;
	}

	/*
	 * retrieve method will take training id and return the program object with
	 * appropriate attributes
	 */
	@Override
	public Program retrieve(final int trainingId) throws ProgramException {
		boolean flag=false;

		return null;
	}

	/* Below method will return set of all the available programs */
	@Override
	public Set<Program> retrieveAll() throws ProgramException {
		
		return null;
		/*
		 * Previous static database Codes // Map<String, Program> map =
		 * DatabaseCollection.program; // if (map == null) { // throw new
		 * DatabaseWriteException("Data not Available in the Database"); // } //
		 * Set<Program> trainingPrograms = new HashSet<Program>(); // for (Program
		 * program : map.values()) { // trainingPrograms.add(program); // } // return
		 * trainingPrograms;
		 */

	}

	@Override
	public boolean delete(Program o) throws ProgramException {
		// TODO Auto-generated method stub
		return false;
	}

}