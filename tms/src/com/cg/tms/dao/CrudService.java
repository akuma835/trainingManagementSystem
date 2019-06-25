package com.cg.tms.dao;
import java.util.*;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;

/**
 * 
 */
public interface CrudService<T> {

	/**
	 * @throws DatabaseWriteException 
	 * 
	 */
	public boolean create(T o) throws DatabaseWriteException;

	/**
	 * 
	 */
	public boolean update(T o);

	/**
	 * @throws DatabaseWriteException 
	 * @throws CourseNotFoundException 
	 * @throws TrainingProgramNotFoundException 
	 * 
	 */
	public T retrieve(String o) throws DatabaseWriteException, CourseNotFoundException, TrainingProgramNotFoundException;

	/**
	 * @throws TrainingProgramNotFoundException 
	 * 
	 */
	public boolean delete(T o) throws TrainingProgramNotFoundException;

	/**
	 * @throws DatabaseWriteException 
	 * 
	 */
	public Set<T> retrieveAll() throws DatabaseWriteException;

}