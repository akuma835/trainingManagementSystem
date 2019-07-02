package com.cg.tms.service;

import com.cg.tms.beans.Program;
import com.cg.tms.beans.Student;
import com.cg.tms.dao.IFetchAllDetails;
import com.cg.tms.dao.IStudentManagement;
import com.cg.tms.dao.StudentServiceDaoImpl;
import com.cg.tms.exception.ProgramException;

public class StudentServiceImpl implements StudentService {
	private IStudentManagement studentOpn;
	
	
	
	

	public StudentServiceImpl(IFetchAllDetails<Student> studentOpn) {
		super();
		this.studentOpn = new StudentServiceDaoImpl() ;
	}

	@Override
	public boolean enrollStudent(Student student, Program program) throws ProgramException {
		boolean status=false;
		status = studentOpn.enrollStudent(student, program);
		return status;
	}

	@Override
	public boolean removeStudent(String studentId, String trainingProgramId) throws ProgramException {
		boolean status =studentOpn.removeStudent(studentId, trainingProgramId);
		return status;
	}

}