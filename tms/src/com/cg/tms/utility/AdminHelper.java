package com.cg.tms.utility;


import com.cg.tms.beans.Course;
import com.cg.tms.beans.Feedback;
import com.cg.tms.beans.Trainer;
import com.cg.tms.service.CourseService;
import com.cg.tms.service.FeedbackService;
import com.cg.tms.service.TrainerService;

public class AdminHelper {

	private Trainer trainer;

	private FeedbackService feedbackOperation;

	private TrainerService trainerManagement;

	private CourseService courseOperation;

	private Course course;

	private Feedback feedback;

	private String generateTrainerId() {

		return "";
	}

}