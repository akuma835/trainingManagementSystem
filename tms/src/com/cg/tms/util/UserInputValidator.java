package com.cg.tms.util;

import com.cg.exception.InvalidFormatInput;
import com.cg.tms.exception.ProgramException;

public class UserInputValidator {

	public static boolean validateName(String name) throws ProgramException  {
		boolean flag = false;
		if (!name.matches("[A-Za-z\\s]{4,}")) {
			throw new ProgramException(
					"Invalid format Name! \n Your name cannot contain special character or digits");
		}
		return true;
	}

	public static boolean validateCourseId(String courseId) throws ProgramException {

		if (!courseId.matches("CD_[0-9]{4}")) {
			throw new ProgramException("Invalid format of input for Course! \n You must use CD_1001 format");
		}
		return true;

	}

	public static boolean validateTrainerId(String trainerId) throws ProgramException  {

		if (!trainerId.matches("TR_[0-9]{4}")) {
			throw new ProgramException("Invalid format of input for Trainer! \n You must use TR_1001 format");
		}
		return true;

	}

	public static boolean validateCenterId(String centerId) throws ProgramException {
		if (!centerId.matches("CN_[0-9]{4}")) {
			throw new ProgramException("Invalid format of input for Center! \n You must use CN_1001 format");
		}
		return true;
	}

	public static boolean validateTrainingId(String trainingId) throws ProgramException {
		if (!trainingId.matches("TP_[0-9]{4}")) {
			throw new ProgramException(
					"Invalid format of input for Training Program! \n You must use TP_1001 format");
		}
		return true;
	}

}