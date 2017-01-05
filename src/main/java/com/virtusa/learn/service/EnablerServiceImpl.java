package com.virtusa.learn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.learn.dao.EnablerDAO;
import com.virtusa.learn.dao.EnablerDAOImpl;
import com.virtusa.learn.dao.LearnerDAO;
import com.virtusa.learn.model.Course;
import com.virtusa.learn.model.Enabler;

@Service
public class EnablerServiceImpl implements EnablerService {

	@Autowired
	private EnablerDAO enablerDAO;

	// Enabler registration
	@Transactional
	public boolean addEnabler(Enabler e) {
		return this.enablerDAO.addEnabler(e);
	}

	// List of enablers
	@Transactional
	public List<Enabler> listenablers() {
		return this.enablerDAO.listenablers();
	}

	// Enabler login
	@Transactional
	public boolean verifyEnabler(String username, String password) {
		boolean b = this.enablerDAO.verifyEnabler(username, password);
		System.out.println(b);
		return b;
	}

	// Delete Enabler
	@Transactional
	public String deleteenabler(String e_id) {
		return this.enablerDAO.deleteenabler(e_id);
	}

	// Enabler's password reset
	@Transactional
	public String reset(String username, String newpassword) {
		return this.enablerDAO.reset(username, newpassword);
	}

	// Enabler's logout
	@Transactional
	public String logoutenabler(HttpServletRequest request,
			HttpServletResponse response) {
		return this.enablerDAO.logoutenabler(request, response);

	}

	// Get enabler details
	@Transactional
	public String enablerdetails(String username) {
		return this.enablerDAO.enablerdetails(username);
	}

}
