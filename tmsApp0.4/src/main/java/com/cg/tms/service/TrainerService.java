package com.cg.tms.service;

import java.util.*;

import com.cg.tms.entity.Employee;
import com.cg.tms.entity.TrainerSkill;
import com.cg.tms.enums.Skills;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public interface TrainerService {

	/**
	 * 
	 */
	public boolean addSkillsToTrainer( String trainerId, Skills skill);

	/**
	 * 
	 */
	public boolean delSkillsToTrainer( String trainerId, Skills skills);

	/**

	 * @throws ProgramException 
	 * 
	 */
	public Employee getTrainerDetails(String trainerId) throws ProgramException;

	/**
	 * @throws DatabaseWriteException 
	 * @throws ProgramException 
	 * @throws CourseNotFoundException 
	 * 
	 */
	public Set<Employee> getAllTrainers() throws ProgramException;

	/**
	 * 
	 */
	public boolean createTrainer(Employee trainer);

}