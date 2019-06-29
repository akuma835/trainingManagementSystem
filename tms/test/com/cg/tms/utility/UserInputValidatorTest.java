package com.cg.tms.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.exception.InvalidFormatInput;
import com.cg.tms.util.UserInputValidator;

public class UserInputValidatorTest {

	@Test
	public void validCourseIdTest() throws InvalidFormatInput {
		assertTrue("Course Id format validation Failed ", UserInputValidator.validateCourseId("CD_1520"));
	}

	@Test
	public void invalidCourseIdTest() throws InvalidFormatInput {
		assertFalse("Course Id format validation Failed ", UserInputValidator.validateCourseId("CS_1520"));
	}

	@Test
	public void courseIdLengthTest() throws InvalidFormatInput {
		assertFalse("Course Id length validation Failed ", UserInputValidator.validateCourseId("CS_152"));

	}

	@Test
	public void validTrainerIdTest() throws InvalidFormatInput {
		assertTrue("Trainer Id format validation Failed ", UserInputValidator.validateTrainerId("TR_1001"));
	}

	@Test
	public void invalidTrainerIdTest() throws InvalidFormatInput {
		assertFalse("Trainer Id format validation Failed ", UserInputValidator.validateTrainerId("BD_1520"));
	}

	@Test
	public void trainerIdLengthTest() throws InvalidFormatInput {
		assertFalse("Trainer Id length validation Failed ", UserInputValidator.validateTrainerId("TR 1520"));

	}

	@Test
	public void validCenterIdTest() throws InvalidFormatInput {
		assertTrue("Center Id format validation Failed ", UserInputValidator.validateCenterId("CN_1001"));
	}

	@Test
	public void invalidCenterIdTest() throws InvalidFormatInput {
		assertFalse("Center Id format validation Failed ", UserInputValidator.validateCenterId("Cp_1520"));
	}

	@Test
	public void centerIdLengthTest() throws InvalidFormatInput {
		assertFalse("Center Id length validation Failed ", UserInputValidator.validateCenterId("CN 1520"));

	}

	@Test
	public void validTrainingIdTest() throws InvalidFormatInput {
		assertTrue("Training Id format validation Failed ", UserInputValidator.validateTrainingId("TP_1001"));
	}

	@Test
	public void invalidTrainingIdTest() throws InvalidFormatInput {
		assertFalse("Training Id format validation Failed ", UserInputValidator.validateTrainingId("FP_1520"));
	}

	@Test
	public void trainingIdLengthTest() throws InvalidFormatInput {
		assertFalse("Training Id length validation Failed ", UserInputValidator.validateTrainingId("TP 1520"));

	}

}
