package com.cg.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.cg.tms.beans.Center;
import com.cg.tms.beans.Course;
import com.cg.tms.beans.Program;
import com.cg.tms.beans.Trainer;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.ConnectionDB;
import com.cg.tms.util.DBQueries;

public class TrainingProgramServiceDaoImpl implements CrudService<Program> {

	@Override
	public boolean create(Program o) throws ProgramException {
		boolean flag = false;
		Connection connection = ConnectionDB.getConnection();
		String sql = DBQueries.CREATE_PROGRAM;
		PreparedStatement preparedStatement;
		try {

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, o.getTrainingId());
			preparedStatement.setString(2, o.getCourse().getCourseId());
			preparedStatement.setString(3, o.getTrainer().getTrainerId());
			preparedStatement.setString(4, o.getCenter().getCenterId());
			preparedStatement.setString(5, String.valueOf(o.getTrainingStartDate()));
			flag = preparedStatement.execute(sql);
			preparedStatement.close();

		} catch (SQLException e) {
			throw new ProgramException(ErrorMessages.MESSAGE4);
		}
		return flag;
	}

	@Override
	public boolean update(Program o) {
		/* Not yet defined */
		return false;
	}

	@Override
	public Program retrieve(String trainingId)
			throws ProgramException {

		Connection connection = ConnectionDB.getConnection();
		String sql = DBQueries.GET_PROGRAM_ID;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, trainingId);
			resultSet = preparedStatement.executeQuery();
			Program program = null;
			while (resultSet.next()) {
				final LocalDate trainingStartDate = LocalDate.parse(resultSet.getString(5));
				final Course course = new CourseServiceDaoImpl().retrieve(resultSet.getString(2));
				final Trainer trainer = new TrainerServiceDaoImpl().retrieve(resultSet.getString(3));
				final Center center = new FetchCentersImpl().retrieve(resultSet.getString(4));

				program = new Program(trainingId, trainingStartDate, course, trainer, center);
			}
			return program;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Set<Program> programs;
		Program trainingProgram = null;
		programs = retrieveAll();
		for (Program tPrograms : programs) {
			if (tPrograms.getTrainingId().equals(trainingId)) {
				trainingProgram = tPrograms;
				break;
			}
		}
		return trainingProgram;

	}

	@Override
	public boolean delete(Program o) throws ProgramException {
		int returnValue;
		boolean flag = false;
		Connection connection = ConnectionDB.getConnection();
		String sql = DBQueries.DELETE_PROGRAM_BY_ID;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, o.getTrainingId());
			returnValue = preparedStatement.executeUpdate();
			preparedStatement.close();

			if (returnValue == 1) {
				flag = true;
			}

		} catch (SQLException e) {
			try {
				preparedStatement.close();
			} catch (SQLException e1) {
				throw new ProgramException(ErrorMessages.MESSAGE5);
			}
		}

		return flag;
	}

	/* Below method will return all the available programs */
	@Override
	public Set<Program> retrieveAll() throws ProgramException {

		Connection connection = ConnectionDB.getConnection();
		String sql = DBQueries.GET_PROGRAMS;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Set<Program> programs = new HashSet<Program>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final String trainingId = resultSet.getString(1);
				final LocalDate trainingStartDate = LocalDate.parse(resultSet.getString(5));
				final Course course = new CourseServiceDaoImpl().retrieve(resultSet.getString(2));
				final Trainer trainer = new TrainerServiceDaoImpl().retrieve(resultSet.getString(3));
				final Center center = new FetchCentersImpl().retrieve(resultSet.getString(4));

				Program program = new Program(trainingId, trainingStartDate, course, trainer, center);
				programs.add(program);
			}
			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e1) {
				throw new ProgramException(ErrorMessages.MESSAGE3);
			}
			throw new ProgramException(ErrorMessages.MESSAGE2);

		}
		return programs;
		/*
		 * previos static database Codes // Map<String, Program> map =
		 * DatabaseCollection.program; // if (map == null) { // throw new
		 * DatabaseWriteException("Data not Available in the Database"); // } //
		 * Set<Program> trainingPrograms = new HashSet<Program>(); // for (Program
		 * program : map.values()) { // trainingPrograms.add(program); // } // return
		 * trainingPrograms;
		 */

	}

}