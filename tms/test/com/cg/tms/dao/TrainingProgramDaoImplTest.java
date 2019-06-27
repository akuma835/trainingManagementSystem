package com.cg.tms.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.beans.Center;
import com.cg.tms.beans.Course;
import com.cg.tms.beans.Program;
import com.cg.tms.beans.Trainer;
import com.cg.tms.dao.DatabaseCollection;
import com.cg.tms.service.TrainingProgramServiceImpl;

public class TrainingProgramDaoImplTest {

	@Before
	public void initializeDB() {
		DatabaseCollection.initiateDB();
	}

	@Test(expected = DatabaseWriteException.class)
	public void alreadyExistTrainingProgramCreationTest() throws DatabaseWriteException {
		Program program = new Program("TP_1001", LocalDate.parse("2019-09-08"),
				new Course("CD_1001", "JAVA", "JAVA Fundamentals", 2500),
				new Trainer("TR_1001", "Mr Vivek Acharya", "Bhubaneswar,IND", DatabaseCollection.tr_1001Skills),
				new Center("CN_1002", "Knowledge Park", "Thane Mumbai"));
		new TrainingProgramServiceImpl().createProgram(program);
	}
	@Test
	public void successfullCreationOfTrainingProgramTest() throws DatabaseWriteException, TrainingProgramNotFoundException {
		Program program = new Program("TP_1003", LocalDate.parse("2019-09-08"),
				new Course("CD_1001", "JAVA", "JAVA Fundamentals", 2500),
				new Trainer("TR_1001", "Mr Vivek Acharya", "Bhubaneswar,IND", DatabaseCollection.tr_1001Skills),
				new Center("CN_1002", "Knowledge Park", "Thane Mumbai"));
		new TrainingProgramServiceImpl().createProgram(program);
		assertEquals(2, DatabaseCollection.program.size());
		new TrainingProgramServiceImpl().deleteTrainingProgram("TP_1003");
	}
	

	@Test(expected = TrainingProgramNotFoundException.class)
	public void ondeleteTrainingProgramNotFoundTest() throws DatabaseWriteException, TrainingProgramNotFoundException {
		new TrainingProgramServiceImpl().deleteTrainingProgram("TR_1008");
	}
	
	@Test
	public void beforeDeletionSizeTest() {
		assertEquals(1, DatabaseCollection.program.size());
	}
	
	@Test
	public void afterDeletionSizeTest() throws DatabaseWriteException, TrainingProgramNotFoundException {
		new TrainingProgramServiceImpl().deleteTrainingProgram("TP_1001");
		assertEquals(0, DatabaseCollection.program.size());
	}

}
