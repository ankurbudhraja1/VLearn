package com.virtusa.learn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.learn.dao.LearnerDAO;
import com.virtusa.learn.model.Course;
import com.virtusa.learn.model.Enabler;
import com.virtusa.learn.model.Learner;

@Service
public class LearnerServiceImpl implements LearnerService {

	@Autowired
	private LearnerDAO learnerDAO;

	// Learner registration
	@Transactional
	public boolean addLearner(Learner p) {
		return this.learnerDAO.addLearner(p);
	}

	// List of learners
	@Transactional
	public List<Learner> listlearners() {
		return this.learnerDAO.listlearners();
	}

	// Delete learner
	@Transactional
	public String deletelearner(String l_id) {
		return this.learnerDAO.deletelearner(l_id);
	}

	// Learner's password reset
	@Transactional
	public String reset(String username, String newpassword) {
		return this.learnerDAO.reset(username, newpassword);
	}

	// Learner login
	@Transactional
	public boolean verifyUser(String username, String password) {
		boolean b = this.learnerDAO.verifyUser(username, password);
		System.out.println(b);
		return b;
	}

	// Learner's logout
	@Transactional
	public String logoutlearner(HttpServletRequest request,
			HttpServletResponse response) {
		return this.learnerDAO.logoutlearner(request, response);

	}

}
