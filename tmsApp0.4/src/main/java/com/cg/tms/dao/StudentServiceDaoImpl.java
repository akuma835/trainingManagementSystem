package com.cg.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.tms.entity.Program;
import com.cg.tms.entity.Student;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.ConnectionDB;
import com.cg.tms.util.DBQueries;

public class StudentServiceDaoImpl implements StudentServiceDao {

	@Override
	public boolean enrollStudent(Student student, Program program) throws ProgramException {
		
		boolean flag= false;
		return flag;
	}

	@Override
	public boolean removeStudent(int studnentId, int trainingProgramId) throws ProgramException {
		boolean flag= false;
		
		return flag;
	}

}
