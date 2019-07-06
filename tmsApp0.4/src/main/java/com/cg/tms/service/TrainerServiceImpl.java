package com.cg.tms.service;

import java.util.Set;

import com.cg.tms.dao.CrudService;
import com.cg.tms.dao.TrainerServiceDaoImpl;
import com.cg.tms.entity.Employee;
import com.cg.tms.entity.TrainerSkill;
import com.cg.tms.enums.Skills;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public class TrainerServiceImpl implements TrainerService {
	CrudService<Employee> crudOperation = new TrainerServiceDaoImpl();
	@Override
	public boolean addSkillsToTrainer(String trainerId, Skills skill) {
		return false;
	}

	@Override
	public boolean delSkillsToTrainer(String trainerId, Skills skills) {
		return false;
	}

	@Override
	public Employee getTrainerDetails(String trainerId) throws ProgramException {
		Employee trainer = crudOperation.retrieve(trainerId);

		return trainer;
	}

	@Override
	public Set<Employee> getAllTrainers() throws ProgramException{
		return crudOperation.retrieveAll();
	}

	@Override
	public boolean createTrainer(Employee trainer) {
		return false;
	}


}