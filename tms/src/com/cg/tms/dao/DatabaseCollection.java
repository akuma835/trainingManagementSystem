package com.cg.tms.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cg.tms.beans.Center;
import com.cg.tms.beans.Course;
import com.cg.tms.beans.Program;
import com.cg.tms.beans.Student;
import com.cg.tms.beans.Trainer;
import com.cg.tms.beans.TrainingProgram;
import com.cg.tms.enums.Skills;

public class DatabaseCollection {

	public static Set<Course> course = new HashSet<>();
	public static List<Center> center = new ArrayList<>();
	public static List<Trainer> trainer = new ArrayList<>();
	public static Set<Skills> tr_1001Skills = new HashSet<>();
	public static Set<Skills> tr_1002Skills = new HashSet<>();
	public static Map<String, Program> program = new HashMap<>();
	public static List<Student> student = new ArrayList<>();
	public static List<TrainingProgram> trPrograms = new ArrayList<>();

	public static void initiateDB() {
		course.add(new Course("CO_1001", "JAVA", "JAVA Fundamentals", 2500));
		course.add(new Course("CO_1002", "C", "C basics", 1500));

		center.add(new Center("CN_1001", "Capgemini SEZ", "Aeroli Navi Mumbai -700080"));
		center.add(new Center("CN_1002", "Knowledge Park", "Thane Mumbai"));

		tr_1001Skills.add(Skills.ANGULAR);
		tr_1001Skills.add(Skills.JAVA);
		trainer.add(new Trainer("TR_1001", "Mr Vivek Acharya", "Bhubaneswar,IND", tr_1001Skills));

		tr_1002Skills.add(Skills.PYTHON);
		tr_1002Skills.add(Skills.JAVA);
		trainer.add(new Trainer("TR_1002", "Manoj Vajpeyi", "Mumbai, IND", tr_1002Skills));

		program.put("TP_1001",
				new Program("TP_1001", LocalDate.parse("2019-09-08"),
						new Course("CD_1001", "JAVA", "JAVA Fundamentals", 2500),
						new Trainer("TR_1001", "Mr Vivek Acharya", "Bhubaneswar,IND", tr_1001Skills),
						new Center("CN_1002", "Knowledge Park", "Thane Mumbai")));

		student.add(new Student("ST_1001", "Amit Kumar"));

		trPrograms.add(new TrainingProgram(new Student("ST_1001", "Amit Kumar"), program.get("TP_1001")));

	}

//	

}
