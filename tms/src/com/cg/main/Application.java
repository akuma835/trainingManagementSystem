package com.cg.main;

import java.util.Scanner;

import com.cg.exception.CourseNotFoundException;
import com.cg.exception.DatabaseWriteException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.tms.beans.Program;
import com.cg.tms.controller.CoordinatorController;
import com.cg.tms.dao.DatabaseCollection;
import com.cg.tms.service.CourseService;

public class Application {
	static Scanner scanner;
	CourseService courseOperation;
	CoordinatorController coordinatorController;
	Program trainingProgram;

	public static void main(String[] args) throws CourseNotFoundException, Exception {
		DatabaseCollection.initiateDB();
		CoordinatorController coordinatorController = new CoordinatorController();
		scanner = new Scanner(System.in);
		System.out.println("_______Welcome to Traingin Management System_____");
		System.out.println("TrainingProgram Module");
		System.out.println("Select Your Operation:------------");
		System.out.println("1. Training Program Management");
		System.out.println("2. Student Management");
		int choice = 0;
		try {
			choice = scanner.nextInt();
		} catch (Exception e) {
			System.err.println("Invalid input choice");
			System.exit(0);
		}

		switch (choice) {
		case 1:
			try {
				coordinatorController.choice1Selection();
			} catch (DatabaseWriteException | CourseNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				System.err.println("Some Error Occured! Please Try after some time");
			}
			break;
		case 2:
			try {
				coordinatorController.choice2Selection();
			} catch (Exception e) {

			}
		case 3:
			System.exit(0);
			break;

		default:
			System.out.println("Wrong Choice");
		}
	}

}
