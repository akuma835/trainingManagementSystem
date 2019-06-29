
package com.cg.tms.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.ExpiredDateException;
import com.cg.exception.InvalidFormatInput;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.beans.Center;
import com.cg.tms.beans.Course;
import com.cg.tms.beans.Program;
import com.cg.tms.beans.Student;
import com.cg.tms.beans.Trainer;
import com.cg.tms.dao.FetchCentersImpl;
import com.cg.tms.dao.IFetchAllDetails;
import com.cg.tms.dao.IStudentManagement;
import com.cg.tms.dao.StudentServiceDaoImpl;
import com.cg.tms.service.CourseService;
import com.cg.tms.service.CourseServiceImpl;
import com.cg.tms.service.TrainerService;
import com.cg.tms.service.TrainerServiceImpl;
import com.cg.tms.service.TrainingProgramServiceImpl;

public class CoordinatorHelper {
	private TrainingProgramServiceImpl traingingProgramOpn;
	private TrainerService trainerOperation;
	private CourseService courseOperation;
//	private IFetchAllDetails<Student> fetchOperation;
	private IStudentManagement studentOpn;

//	public CoordinatorHelper() {
//		this.courseOperation = new CourseServiceImpl();
//		this.traingingProgramOpn = new TrainingProgramServiceImpl();
//		this.trainerOperation = new TrainerServiceImpl();
//		this.courseOperation = new CourseServiceImpl();
////		this.fetchOperation = new FetchStudentImpl();
//		this.studentOpn = new StudentServiceDaoImpl();
//	}
//
//	public boolean enrollPariticipant(Student student, Program trainingProgram) {
//		student.setStudentId(generateStudentId());
//		studentOpn.enrollStudent(student, trainingProgram);
//		return true;
//	}
//
//	public boolean validateCourseAddition(Course course) {
//		/* Assigned to Sammanita Priyadarshini */
//		return false;
//	}
//
//	public boolean createTrainingProgramService(Program program) throws DatabaseWriteException {
//		program.setTrainingId(generateTrainingId());
//		boolean flag = traingingProgramOpn.createProgram(program);
//		return flag;
//	}

	public static  boolean isDatenotExpired(String inputDate) {
		LocalDate startDate = null;
		try {
			startDate = LocalDate.parse(inputDate);
			if (startDate.isBefore(LocalDate.now())) {
				throw new ExpiredDateException("Date is already gone.Backdate not possible");
			}
		} catch (ExpiredDateException e) {
			System.err.println(e.getMessage());
			System.exit(0);
		} catch (DateTimeParseException e) {
			throw e;
		}
		return true;
	}

	/*
	 * Validater: User input is verified below whether it is in correct format
	 * below:-------------------
	 */
//	private boolean validateInputCourseId(String courseId) throws InvalidFormatInput {
//		if (!UserInputValidator.validateCourseId(courseId)) {
//			throw new InvalidFormatInput("Invalid Format for CourseId\n Use CD_1002 format");
//		}
//		return true;
//	}
//
//	private boolean validateInputTrainerId(String trainerId) throws InvalidFormatInput {
//		if (!UserInputValidator.validateTrainerId(trainerId)) {
//			throw new InvalidFormatInput("Invalid Format for TrainerId\n Use TR_1002 format");
//		}
//		return true;
//
//	}
//
//	private boolean validateInputCenterId(String centerId) throws InvalidFormatInput {
//		if (!UserInputValidator.validateCenterId(centerId)) {
//			throw new InvalidFormatInput("Invalid Format for CenterId\n Use CN_1002 format");
//		}
//		return true;
//
//	}

	/*
	 * Validater: User input is verified below whether it is in correct format
	 * above:-------------------
	 */

	/*
	 * Database validation whether entered data matched with or not , if matched
	 * return object of respective data
	 * below---------------------------------------------------
	 */

//	public Set<Course> getAvailableCourses() throws DatabaseWriteException {
//		Set<Course> courses = courseOperation.getAllCourse();
//		return courses;
//	}
//
//	public Course getValidCourse(String courseId) throws DatabaseWriteException, CourseNotFoundException,
//			InvalidFormatInput, TrainingProgramNotFoundException {
//		validateInputCourseId(courseId);
//		Course course = courseOperation.getCourseDetails(courseId);
//		return course;
//	}
//
//	public List<Center> getAllAvailableCenters() {
//		List<Center> centers = new ArrayList<>();
//		IFetchAllDetails<Center> fetchOperation = new FetchCentersImpl();
//		centers = fetchOperation.retrieveAll();
//		return centers;
//	}
//
//	public Center getValidCenter(String centerId) throws InvalidFormatInput {
//
//		Center center = null;
//		List<Center> centers = getAllAvailableCenters();
//		for (Center centerItr : centers) {
//			if (centerItr.getCenterId().equals(centerId)) {
//				center = centerItr;
//				break;
//			}
//		}
//		return center;
//	}
//
//	public Set<Trainer> getAllTrainersAvailable() throws DatabaseWriteException {
//		Set<Trainer> trainers = new HashSet<>();
//		trainers = trainerOperation.getAllTrainers();
//		return trainers;
//	}
//
//	public Trainer getAvailableTrainer(String trainerId) throws DatabaseWriteException, CourseNotFoundException,
//			InvalidFormatInput, TrainingProgramNotFoundException {
//		validateInputTrainerId(trainerId);
//		Trainer trainer = trainerOperation.getTrainerDetails(trainerId);
//		return trainer;
//	}

	/*
	 * Database validation whether entered data matched with or not , if matched
	 * return object of respective data
	 * above---------------------------------------------------
	 */

	/*
	 * Generate id method is used to generate unique id by taking the today's day in
	 * two digit and concatenating with static variable which is earlier initialize
	 * by 10
	 */


	/*
	 * Coordinator Services Operation
	 */
//	public Program getTrainingProgramDetails(String trainingId)
//			throws DatabaseWriteException, TrainingProgramNotFoundException {
//		return traingingProgramOpn.retrieveTrainingProgram(trainingId);
//	}
//
//	public Set<Program> getAllTrainingPrograms() throws DatabaseWriteException {
//		return traingingProgramOpn.retrieveAllTrainingProgram();
//	}
//
//	public void deleteTrainingProgram(String trainingId)
//			throws DatabaseWriteException, TrainingProgramNotFoundException {
//		traingingProgramOpn.deleteTrainingProgram(trainingId);
//
//	}
	
	
	public static String generateStudentId() {
		StringBuilder studentId = new StringBuilder("ST_");
		int number = LocalDate.now().getDayOfMonth();
		if (number < 10) {
			studentId.append('0');
		}
		studentId.append(number);
		studentId.append(Student.studentSeq++);
		return String.valueOf(studentId);
	}

	public static String generateTrainingId() {
		StringBuilder trainingId = new StringBuilder("TP_");
		int number = LocalDate.now().getDayOfMonth();
		if (number < 10) {
			trainingId.append('0');
		}
		trainingId.append(number);
		trainingId.append(Program.tProgramSeq++);
		return String.valueOf(trainingId);
	}

}