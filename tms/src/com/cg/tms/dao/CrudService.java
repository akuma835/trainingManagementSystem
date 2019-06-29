package com.cg.tms.dao;
import java.util.*;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public interface CrudService<T> {

	/**
	 * @throws DatabaseWriteException 
	 * @throws ProgramException 
	 * 
	 */
	public boolean create(T o) throws ProgramException;

	/**
	 * 
	 */
	public boolean update(T o);

	/**
	 * @throws DatabaseWriteException 
	 * @throws CourseNotFoundException 
	 * @throws TrainingProgramNotFoundException 
	 * @throws ProgramException 
	 * 
	 */
	public T retrieve(String o) throws ProgramException;

	/**
	 * @throws TrainingProgramNotFoundException 
	 * @throws ProgramException 
	 * 
	 */
	public boolean delete(T o) throws ProgramException;

	/**
	 * @throws DatabaseWriteException 
	 * @throws ProgramException 
	 * @throws CourseNotFoundException 
	 * 
	 */
	public Set<T> retrieveAll() throws ProgramException;

}