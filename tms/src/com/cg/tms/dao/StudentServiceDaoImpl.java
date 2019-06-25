package com.cg.tms.dao;

import com.cg.tms.entity.Program;
import com.cg.tms.entity.Student;
import com.cg.tms.entity.TrainingProgram;

public class StudentServiceDaoImpl implements IStudentManagement {

	@Override
	public boolean enrollStudent(Student student, Program program) {
		boolean flag= false;
		TrainingProgram trainingProgram = new TrainingProgram(student,program);
		flag = DatabaseCollection.trPrograms.add(trainingProgram);
		return flag;
		
	}

	@Override
	public boolean removeStudent(String studnentId, String trainingProgramId) {
		/* Not yet Implemented*/
		return false;
	}

	

	

}
