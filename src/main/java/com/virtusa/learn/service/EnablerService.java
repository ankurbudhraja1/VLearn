package com.virtusa.learn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.learn.model.Course;
import com.virtusa.learn.model.Enabler;

public interface EnablerService {
	// Enabler registration
	public boolean addEnabler(Enabler e);

	// Enabler login
	public boolean verifyEnabler(String username, String password);

	// Get enabler details
	public String enablerdetails(String username);

	// List of enablers
	public List<Enabler> listenablers();

	// Delete Enabler
	public String deleteenabler(String e_id);

	// Enabler's password reset
	public String reset(String username, String newpassword);

	// Enabler's logout
	public String logoutenabler(HttpServletRequest request,
			HttpServletResponse response);

}
