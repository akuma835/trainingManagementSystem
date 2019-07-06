package com.cg.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STUDENT")
	@SequenceGenerator(sequenceName = "seq_student", allocationSize = 1, name = "SEQ_STUDENT")

	private int studentId;
	private String studentName;
	
	
	@Column(name="trainingId")
	private Program program;
	
	public Student() {};

	public Student(int studentId, String studentName, Program program) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.program = program;

	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}




	@Override
	public String toString() {
		return "Student Id " + getStudentId() + "Name: " + getStudentName();
	}

}