package com.cg.tms.controller;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.InvalidFormatInput;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.beans.Center;
import com.cg.tms.beans.Course;
import com.cg.tms.beans.Program;
import com.cg.tms.beans.Student;
import com.cg.tms.beans.Trainer;
import com.cg.tms.dao.DatabaseCollection;
import com.cg.tms.dao.FetchCentersImpl;
import com.cg.tms.dao.IFetchAllDetails;
import com.cg.tms.dao.IStudentManagement;
import com.cg.tms.dao.StudentServiceDaoImpl;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.service.CourseService;
import com.cg.tms.service.CourseServiceImpl;
import com.cg.tms.service.TrainerService;
import com.cg.tms.service.TrainerServiceImpl;
import com.cg.tms.service.TrainingProgramService;
import com.cg.tms.service.TrainingProgramServiceImpl;
import com.cg.tms.util.CoordinatorHelper;
import com.cg.tms.util.UserInputValidator;

public class CoordinatorController {
	Scanner scanner;
	private CoordinatorHelper coordinatorService;
	private TrainingProgramService traingingProgramOpn;
	private TrainerService trainerOperation;
	private CourseService courseOperation;
//	private IFetchAllDetails<Student> fetchOperation;
	private IStudentManagement studentOpn;

	public CoordinatorController() {

		this.traingingProgramOpn = new TrainingProgramServiceImpl();
		this.trainerOperation = new TrainerServiceImpl();
		this.courseOperation = new CourseServiceImpl();
		this.studentOpn = new StudentServiceDaoImpl();
	}

	public void choice1Selection()
			throws InvalidFormatInput, ProgramException {
		scanner = new Scanner(System.in);
		System.out.println("Select your option:---");
		System.out.println("1. Create a Training Program");
		System.out.println("2. Get the Program Details");
		System.out.println("3. Delete the Existing Program");
		System.out.println("4. Get the All running training program");
		System.out.println("5. Modify the existing Course");
		System.out.println("6. Exit");
		try {
			final int subChoice = scanner.nextInt();
			switch (subChoice) {
			case 1:
				createProgram();
				break;
			case 2:
				getProgramDetails();
				break;
			case 3:
				deleteProgram();
				break;
			case 4:
				getAllRunningPrograms();
				break;
			case 5:
				updateTrainingProgram();
			case 6:
				System.exit(0);
			default:
				System.out.println("Wrong choice entered!");
			}
		} catch (TrainingProgramNotFoundException | DateTimeParseException | InvalidFormatInput e) {
			System.err.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println("Wrong format input");
		}

	}

	private void updateTrainingProgram() {

	}

	private void getProgramDetails() throws ProgramException{
		System.out.println("Enter the Training Program Id from the list of Available Programs");
		getAllRunningPrograms();
		final String trainingId = scanner.next();
		UserInputValidator.validateTrainingId(trainingId);
		Program program = traingingProgramOpn.retrieveTrainingProgram(trainingId);

		System.out
				.println("Training Id: " + program.getTrainingId() + " Start Date: " + program.getTrainingStartDate());

		System.out.println("Course Details:  ");
		System.out.println(program.getCourse());

		System.out.println("Trainer Details: ");
		System.out.println("Trainer Name: " + program.getTrainer().getTrainerName() + " Skills: "
				+ program.getTrainer().getSkills());

		System.out.println("Running Centers Details ");
		System.out.println(program.getCenter());

	}

	private void getAllRunningPrograms() throws ProgramException{
		System.out.println("Currently Running Programs:******************");
		Set<Program> programs = traingingProgramOpn.retrieveAllTrainingProgram();
//		programs.forEach(System.out::println);
//		programs.forEach();
//		programs.forEach(System.out.println((p)->p.getTrainingId().equals("TP_1001")));
		Stream<Program> stream = programs.stream();
		
//		programs.
	
		Predicate<Program> p1 = (p)->p.getTrainingId().equals("TP_1002");
		Consumer<Program> c1 = (p)->{
//			if(p1.test(p))
			System.out.println(p);
		
		};
//		Supplier<Program> s1 = new 
		stream.filter(p1).forEach(c1);
//		programs.forEach(c1);

	}

	private void deleteProgram() throws ProgramException{
		System.out.println("Select the trainingProgram You want to delete");
		getAllRunningPrograms();
		System.out.println("Enter the Training Program Id");
		final String trainingId = scanner.next();

		UserInputValidator.validateTrainingId(trainingId);

		System.out.println("Before Deletion" + DatabaseCollection.program.size());
		traingingProgramOpn.deleteTrainingProgram(trainingId);
		System.out.println("Suceessfully Deleted");
		System.out.println("After Deletion" + DatabaseCollection.program.size());
	}

	private void createProgram() throws ProgramException,
			InvalidFormatInput, TrainingProgramNotFoundException, ProgramException {
		System.out.println("Enter Training start " + "Date: yyyy-mm-dd ");
		final String inputDate = scanner.next();
		CoordinatorHelper.isDatenotExpired(inputDate);
		final LocalDate startDate = LocalDate.parse(inputDate);

		System.out.println("Enter CourseId from the below Available Course");
		Set<Course> courses = courseOperation.getAllCourse();
		courses.forEach(System.out::println);
		System.out.println("Enter CourseId:");
		final String courseId = scanner.next();
		UserInputValidator.validateCourseId(courseId);
		Course course = courseOperation.getCourseDetails(courseId);

		System.out.println("Pickup the trainer by Entering TrainerId: ");
		Set<Trainer> trainers = trainerOperation.getAllTrainers();
		trainers.forEach(System.out::println);
		final String trainerId = scanner.next();
		UserInputValidator.validateTrainerId(trainerId);
		Trainer trainer = trainerOperation.getTrainerDetails(trainerId);

		System.out.println("PickUp the Center by entering CenterId");
		IFetchAllDetails<Center> fetchOperation = new FetchCentersImpl();
		List<Center> centers = fetchOperation.retrieveAll();
		centers.forEach(System.out::println);
		final String centerId = scanner.next();
		UserInputValidator.validateCenterId(centerId);
		Center center = null;
//		List<Center> centers = getAllAvailableCenters();
		for (Center centerItr : centers) {
			if (centerItr.getCenterId().equals(centerId)) {
				center = centerItr;
				break;
			}
		}
//		Center center = coordinatorService.getValidCenter(centerId);

		/* We are going to generate trainingId in trainingProgramImpl() */
		String trainingId = CoordinatorHelper.generateStudentId();
		Program trainingProgram = new Program(trainingId, startDate, course, trainer, center);

		System.out.println("Before addition" + DatabaseCollection.program.size());
		traingingProgramOpn.createProgram(trainingProgram);
		System.out.println("After addition" + DatabaseCollection.program.size());

	}

	public void choice2Selection() throws InvalidFormatInput, DatabaseWriteException, TrainingProgramNotFoundException, ProgramException, CourseNotFoundException {
		scanner = new Scanner(System.in);
		System.out.println("Select your option:---");
		System.out.println("1. Enroll Student");
		System.out.println("2. Remove Student");
		System.out.println("3. Exit");
		try {
			final int subChoice = scanner.nextInt();
			switch (subChoice) {
			case 1:
				enrollStudent();
				break;
			case 2:
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Wrong choice entered!");
			}
		} catch (InputMismatchException e) {
			System.err.println("Wrong format input");
		}

	}

	private void enrollStudent() throws InvalidFormatInput, DatabaseWriteException, TrainingProgramNotFoundException, ProgramException, CourseNotFoundException {

		System.out.println("Enter the Student First Name");
		String studentFirstName = scanner.next();
		System.out.println("Enter the Student Last Name");
		String studentLastName = scanner.next();
		final String studentName = studentFirstName + " " + studentLastName;
		UserInputValidator.validateName(studentName);
		String studentId = CoordinatorHelper.generateStudentId();

		System.out.println("Select the available training Program");
		Set<Program> programs = traingingProgramOpn.retrieveAllTrainingProgram();
		programs.forEach(System.out::println);
		System.out.println("Enter the selected TrainingProgram ID");
		final String programId = scanner.next();
		UserInputValidator.validateTrainingId(programId);

		Student student = new Student(studentId, studentName);
		Program program = traingingProgramOpn.retrieveTrainingProgram(programId);
		studentOpn.enrollStudent(student, program);
		System.out.println("SUCCESS" + DatabaseCollection.trPrograms.size());

	}

}
