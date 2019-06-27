package com.cg.tms.beans;

public class TrainingProgram {
	
	private Student student;
	private Program program;
	
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
