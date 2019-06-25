package com.cg.tms.dao;

import com.cg.tms.entity.Program;
import com.cg.tms.entity.Student;

public interface IStudentManagement {
 public boolean enrollStudent(Student student,Program program);
 public boolean removeStudent(String studnentId,String trainingProgramId);
}
