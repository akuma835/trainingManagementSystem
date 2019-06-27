package com.cg.tms.beans;

import java.time.LocalDate;
import java.util.*;

import javax.xml.stream.events.StartDocument;

/**
 * 
 */
public class Program {
	private String trainingId;
	private LocalDate trainingStartDate;
	private Course course;
	private Trainer trainer;
	private Center center;
	public static int tProgramSeq = 10;

	public static final Comparator<Program> BY_TRAININGID = Comparator
			.comparing(Program::getTrainingId);

	public Program(String trainingId, LocalDate trainingStartDate, Course course, Trainer trainer,
			Center center) {

		this.trainingId = trainingId;
		this.trainingStartDate = trainingStartDate;
		this.course = course;
		this.trainer = trainer;
		this.center = center;
		tProgramSeq++;

	}

	public String getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}

	public LocalDate getTrainingStartDate() {
		return trainingStartDate;
	}

	public void setTrainingStartDate(LocalDate trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Training ID: " + trainingId + " Start Date: " + trainingStartDate + " Course " + course.getCourseName()
				+ " Trainer " + trainer.getTrainerName() + " Center Name: " + center.getCenterName();
	}

}