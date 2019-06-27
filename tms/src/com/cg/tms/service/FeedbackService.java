package com.cg.tms.service;

import com.cg.tms.beans.Feedback;
import com.cg.tms.beans.Program;

public interface FeedbackService {

	public Feedback viewFeedbackReport();

	public Feedback viewDefaulterList(Program trainingProgram, Feedback feedback);

}