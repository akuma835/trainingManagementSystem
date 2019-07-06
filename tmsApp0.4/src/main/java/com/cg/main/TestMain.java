package com.cg.main;



import javax.persistence.EntityManager;

import com.cg.tms.entity.Program;
import com.cg.tms.util.EntityManagerUtils;

public class TestMain {
	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		Program p = entityManager.find(Program.class, 10000);
	System.out.println(p.getTrainingId());
	}

}
