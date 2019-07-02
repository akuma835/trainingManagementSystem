package com.cg.tms.beans;

import java.io.Serializable;

public class TrainingProgram implements Serializable {
	
	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	private Program program;
	
	/***
	 * Constructors
	 * @param student
	 * @param program
	 */
	public TrainingProgram(Student student, Program program) {
		super();
		this.student = student;
		this.program = program;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	

}
