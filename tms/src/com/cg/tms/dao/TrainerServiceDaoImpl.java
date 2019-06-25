package com.cg.tms.dao;

import java.util.*;

import com.cg.tms.entity.Course;
import com.cg.tms.entity.Program;
import com.cg.tms.entity.Trainer;

/**
 * 
 */
public class TrainerServiceDaoImpl implements CrudService<Trainer> {
	Set<Trainer> trainers = new HashSet<Trainer>();
	Iterator<Trainer> trainerIterator = trainers.iterator();
	@Override
	public boolean create(Trainer o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Trainer o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Trainer retrieve(String trainerId) {
		retrieveAll();
		for (Trainer trainer : trainers) {
			if (trainerId.equals(trainer.getTrainerId())) {
				return trainer;
			}
		}

		return null;
	}

	@Override
	public boolean delete(Trainer o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Trainer> retrieveAll() {
		trainers.addAll(DatabaseCollection.trainer);
		return trainers;
		
	}

	

}