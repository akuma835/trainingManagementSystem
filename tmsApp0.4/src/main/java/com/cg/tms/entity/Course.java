package com.cg.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	public Course() {};
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COURSE")
	@SequenceGenerator(sequenceName = "seq_course", allocationSize = 1, name = "SEQ_COURSE")

	@Column(name = "courseId")
	private String courseId;
	
	@Column(name = "courseName")
	private String courseName;
	
	@Column(name = "courseDesc")
	private String courseDesc;
	
	@Column(name = "courseCharges")
	private int courseCharges;

	public Course(String courseId, String courseName, String courseDesc, int courseCharges) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
		this.courseCharges = courseCharges;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public int getCourseCharges() {
		return courseCharges;
	}

	public void setCourseCharges(int courseCharges) {
		this.courseCharges = courseCharges;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getCourseId() == getCourseId();
	}

	@Override
	public int hashCode() {
		return this.getCourseId().hashCode();
	}

	@Override
	public String toString() {
		return "Course ID: " + courseId + " Course Name: " + courseName + " Courses Charges " + courseCharges
				+ " Course desc: " + courseDesc;
	}

}