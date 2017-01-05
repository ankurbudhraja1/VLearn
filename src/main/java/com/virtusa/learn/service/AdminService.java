package com.virtusa.learn.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AdminService {
	// admin's login process
	public boolean verifyAdmin(String username, String password);

	// admin's password reset
	public String reset(String username, String newpassword);

	// admin's logout
	public String logoutadmin(HttpServletRequest request,
			HttpServletResponse response);
}
