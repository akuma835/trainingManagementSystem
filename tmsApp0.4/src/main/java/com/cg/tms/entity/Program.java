package com.cg.tms.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "program")
public class Program implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROGRAM")
	@SequenceGenerator(sequenceName = "seq_program", allocationSize = 1, name = "SEQ_PROGRAM")

	@Column(name = "trainingId")
	private String trainingId;
	@Column(name = "startDate")
	private LocalDate trainingStartDate;
	@OneToOne
	@JoinColumn(name = "courseId")
	private Course course;
	@OneToOne
	@JoinColumn(name = "trainerId")
	private Employee employee;
	@OneToOne
	@JoinColumn(name = "centerId")
	private Center center;

//	public static final Comparator<Program> BY_TRAININGID = Comparator.comparing(Program::getTrainingId);

	public Program() {
	}
	
	

	public Program(String trainingId, LocalDate trainingStartDate, Course course, Employee employee, Center center) {
	this.trainingId = trainingId;
	this.trainingStartDate = trainingStartDate;
	this.course = course;
	this.employee = employee;
	this.center = center;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	
	
//	@Override
//	public String toString() {
//		return "Training ID: " + trainingId + " Start Date: " + trainingStartDate + " Course " + course.getCourseName()
//				+ " Trainer " + trainer. + " Center Name: " + center.getCenterName();
//	}

}