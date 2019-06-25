package com.cg.tms.service;

import java.util.*;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.entity.Trainer;
import com.cg.tms.enums.Skills;

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
	 * @throws DatabaseWriteException 
	 * @throws CourseNotFoundException 
	 * @throws TrainingProgramNotFoundException 
	 * 
	 */
	public Trainer getTrainerDetails(String trainerId) throws DatabaseWriteException, CourseNotFoundException, TrainingProgramNotFoundException;

	/**
	 * @throws DatabaseWriteException 
	 * 
	 */
	public Set<Trainer> getAllTrainers() throws DatabaseWriteException;

	/**
	 * 
	 */
	public boolean createTrainer(Trainer trainer);

}