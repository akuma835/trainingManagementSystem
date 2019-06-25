package com.cg.tms.utility;

import com.cg.exception.InvalidFormatInput;

public class UserInputValidator {

	public static boolean validateName(String name) throws InvalidFormatInput {
		boolean flag = false;
		if (!name.matches("[A-Za-z\\s]{4,}")) {
			throw new InvalidFormatInput(
					"Invalid format Name! \n Your name cannot contain special character or digits");
		}
		return true;
	}

	public static boolean validateCourseId(String courseId) throws InvalidFormatInput {

		if (!courseId.matches("CD_[0-9]{4}")) {
			throw new InvalidFormatInput("Invalid format of input for Course! \n You must use CD_1001 format");
		}
		return true;

	}

	public static boolean validateTrainerId(String trainerId) throws InvalidFormatInput {

		if (!trainerId.matches("TR_[0-9]{4}")) {
			throw new InvalidFormatInput("Invalid format of input for Trainer! \n You must use TR_1001 format");
		}
		return true;

	}

	public static boolean validateCenterId(String centerId) throws InvalidFormatInput {
		if (!centerId.matches("CN_[0-9]{4}")) {
			throw new InvalidFormatInput("Invalid format of input for Center! \n You must use CN_1001 format");
		}
		return true;
	}

	public static boolean validateTrainingId(String trainingId) throws InvalidFormatInput {
		if (!trainingId.matches("TP_[0-9]{4}")) {
			throw new InvalidFormatInput(
					"Invalid format of input for Training Program! \n You must use TP_1001 format");
		}
		return true;
	}

}