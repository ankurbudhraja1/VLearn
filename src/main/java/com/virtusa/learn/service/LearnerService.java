package com.virtusa.learn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.learn.model.Course;
import com.virtusa.learn.model.Enabler;
import com.virtusa.learn.model.Learner;

public interface LearnerService {
	// Learner registration
	public boolean addLearner(Learner p);

	// Learner login
	public boolean verifyUser(String username, String password);

	// List of learners
	public List<Learner> listlearners();

	// Delete learner
	public String deletelearner(String l_id);

	// Learner's logout
	public String logoutlearner(HttpServletRequest request,
			HttpServletResponse response);

	// Learner's password reset
	public String reset(String username, String newpassword);

}
