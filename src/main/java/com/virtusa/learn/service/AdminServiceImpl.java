package com.virtusa.learn.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.learn.dao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	// admin's login process
	@Transactional
	public boolean verifyAdmin(String username, String password) {
		boolean b = this.adminDAO.verifyAdmin(username, password);
		System.out.println(b);
		return b;
	}

	// admin's password reset
	@Transactional
	public String reset(String username, String newpassword) {
		return this.adminDAO.reset(username, newpassword);
	}

	// admin's logout
	@Transactional
	public String logoutadmin(HttpServletRequest request,
			HttpServletResponse response) {
		return this.adminDAO.logoutadmin(request, response);

	}
}
