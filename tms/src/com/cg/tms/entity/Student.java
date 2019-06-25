package com.cg.tms.entity;

public class Student {

	private String studentId;
	private String studentName;
	public static int studentSeq=10;
	
	public Student(String studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		studentSeq++;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public int hashCode() {
		return this.studentId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.getStudentId().equals(((Student)obj).getStudentId());
	}

	@Override
	public String toString() {
		return "Student Id "+getStudentId()+"Name: "+getStudentName();
	}
	

	


}