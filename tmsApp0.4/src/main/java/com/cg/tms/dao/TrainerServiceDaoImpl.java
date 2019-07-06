package com.cg.tms.dao;

import java.sql.Connection;
import java.util.Set;

import com.cg.tms.entity.Employee;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */

public class TrainerServiceDaoImpl implements CrudService<Employee> {
	private Connection connection;

//	Iterator<Trainer> trainerIterator = trainers.iterator();
	@Override
	public boolean create(Employee o) {
		return false;
	}

	@Override
	public boolean update(Employee o) {
		return false;
	}

	@Override
	public Employee retrieve(String trainerId) throws ProgramException {
		Set<Employee> trainerSet = retrieveAll();
		for (Employee trainer : trainerSet) {
			if (trainerId.equals(trainer.getEmpId())) {
				return trainer;
			}
		}

		return null;
	}

	@Override
	public boolean delete(Employee o) {
		return false;
	}

	@Override
	public Set<Employee> retrieveAll() throws ProgramException {
		return null;
	}
}