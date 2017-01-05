package com.virtusa.learn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.learn.model.Course;
import com.virtusa.learn.model.Enabler;
import com.virtusa.learn.model.Learner;
import com.virtusa.learn.service.AdminService;
import com.virtusa.learn.service.CourseService;
import com.virtusa.learn.service.EnablerService;
import com.virtusa.learn.service.LearnerService;

@Controller
public class HelloController {

	@Autowired
	private LearnerService learnerService;

	@Autowired
	private EnablerService enablerService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private CourseService courseService;

	private static final Logger logger = Logger
			.getLogger(HelloController.class);

	HttpSession session;

	// Learner Registration
	@RequestMapping(value = "/addlearner", method = RequestMethod.POST)
	public ModelAndView addLearner(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("hi**");

		// String l_id=request.getParameter("id");
		String l_name = request.getParameter("name");
		String l_city = request.getParameter("city");
		String l_phone = request.getParameter("phone");
		String l_email = request.getParameter("email");
		String l_username = request.getParameter("username");
		String l_password = request.getParameter("password");

		Learner learner = new Learner(l_name, l_city, l_phone, l_email,
				l_username, l_password);
		
		boolean b = this.learnerService.addLearner(learner);
		if (b) {

			// logs debug message
			if (logger.isDebugEnabled()) {
				logger.debug("addlearner is executed!");
			}
			
			String message = "Successfully registered";
			return new ModelAndView("index", "message", message);
		} else {

			// logs debug message
			if (logger.isDebugEnabled()) {
				logger.debug("Error in addlearner, username exists!");
			}

			String message = "Username exists.. please try another username";
			return new ModelAndView("registerlearner", "message", message);
		}

	}

	// Enabler registration
	@RequestMapping(value = "/addenabler", method = RequestMethod.POST)
	public ModelAndView addEnabler(HttpServletRequest request,
			HttpServletResponse response) {

		// String e_id=request.getParameter("id");
		String e_name = request.getParameter("name");
		String e_city = request.getParameter("city");
		String e_phone = request.getParameter("phone");
		String e_email = request.getParameter("email");
		String e_username = request.getParameter("username");
		String e_password = request.getParameter("password");

		Enabler enabler = new Enabler(e_name, e_city, e_phone, e_email,
				e_username, e_password);

		boolean b = this.enablerService.addEnabler(enabler);

		if (b) {

			// logs debug message
			if (logger.isDebugEnabled()) {
				logger.debug("addenabler is executed!");
			}

			String message = "Successfully registered";
			return new ModelAndView("index", "message", message);
		}

		else {

			// logs debug message
			if (logger.isDebugEnabled()) {
				logger.debug("Error in addenabler, username exists!");
			}

			String message = "Username exists.. please try another username";
			return new ModelAndView("registerenabler", "message", message);
		}

	}

	// Adding course
	@RequestMapping(value = "/addcourseprocess", method = RequestMethod.POST)
	public ModelAndView handleFileUpload(HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] fileUpload1,
			@RequestParam CommonsMultipartFile[] fileUpload2,
			@RequestParam CommonsMultipartFile[] fileUpload3) throws Exception {

		Course course = new Course();
		course.setC_name(request.getParameter("name"));
		course.setC_description(request.getParameter("description"));
		course.setC_e_date(request.getParameter("date"));
		course.setC_e_time(request.getParameter("time"));
		course.setC_e_venue(request.getParameter("venue"));
		course.setE_id(request.getParameter("e_id"));

		if (fileUpload1 != null && fileUpload1.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload1) {

				System.out.println("Saving file: "
						+ aFile.getOriginalFilename());

				course.setC_material1(aFile.getBytes());

			}
		}

		if (fileUpload2 != null && fileUpload2.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload2) {

				System.out.println("Saving file: "
						+ aFile.getOriginalFilename());

				course.setC_material2(aFile.getBytes());

			}
		}

		if (fileUpload3 != null && fileUpload3.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload3) {

				System.out.println("Saving file: "
						+ aFile.getOriginalFilename());

				course.setC_material3(aFile.getBytes());

			}
		}

		this.courseService.save(course);

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("addcourseprocess is executed!!");
		}

		String message = "Course added successfully";
		return new ModelAndView("enabler_home", "message", message);
	}

	// Downloading material
	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public String download(@RequestParam("c_id") String c_id,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println(c_id);
		Course course = this.courseService.download(c_id);
		try {

			// FileOutputStream fos = new
			// FileOutputStream("images\\output.jpg"); //windows

			if (course.getC_material1() != null) {
				FileOutputStream fos1 = new FileOutputStream(
						"C:\\Users\\bankur\\Downloads\\material1-" + c_id
								+ ".pdf");
				fos1.write(course.getC_material1());
				fos1.close();
			}

			if (course.getC_material2() != null) {
				FileOutputStream fos2 = new FileOutputStream(
						"C:\\Users\\bankur\\Downloads\\material2-" + c_id
								+ ".pdf");
				fos2.write(course.getC_material2());
				fos2.close();
			}

			if (course.getC_material3() != null) {
				FileOutputStream fos3 = new FileOutputStream(
						"C:\\Users\\bankur\\Downloads\\self-assessment-" + c_id
								+ ".pdf");
				fos3.write(course.getC_material3());
				fos3.close();
			}

			// fos1.write(course.getC_material1());
			// fos2.write(course.getC_material2());
			// fos3.write(course.getC_material3());

			// fos1.close();
			// fos2.close();
			// fos3.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("download is executed!");
		}

		// String message="Successfully downloaded";
		return "redirect:/viewcourselearner";
		// return new ModelAndView("learner_home","message",message);

	}

	// List of courses for particular enabler
	@RequestMapping(value = "/managecourseenabler", method = RequestMethod.GET)
	public ModelAndView managecourseenabler(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String e_id = (String) request.getSession().getAttribute("e_id");

		List<Course> courses = this.courseService.managecourseenabler(e_id);
		System.out.println(courses);

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("managecourseenabler is executed!");
		}

		return new ModelAndView("managecourse2", "courses", courses);
	}

	// List of all courses
	@RequestMapping(value = "/managecourseadmin", method = RequestMethod.GET)
	public ModelAndView managecourseadmin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Course> courses = this.courseService.managecourseadmin();
		System.out.println(courses);

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("managecourseadmin is executed!");
		}

		return new ModelAndView("managecourse3", "courses", courses);
	}

	// List of enablers
	@RequestMapping(value = "/listenablers", method = RequestMethod.GET)
	public ModelAndView listenablers(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// String e_id = (String) request.getSession().getAttribute("e_id");

		List<Enabler> enablers = this.enablerService.listenablers();

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("listenablers is executed!");
		}

		return new ModelAndView("listenablers", "enablers", enablers);
	}

	// List of learners
	@RequestMapping(value = "/listlearners", method = RequestMethod.GET)
	public ModelAndView listlearners(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Learner> learners = this.learnerService.listlearners();

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("listlearners is executed!");
		}

		return new ModelAndView("listlearners", "learners", learners);
	}

	// Delete courses by enabler
	@RequestMapping(value = "/deletecourseenabler", method = RequestMethod.POST)
	public String deletecourseenabler(@RequestParam("c_id") String c_id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		this.courseService.deletecourseenabler(c_id);

		if (logger.isDebugEnabled()) {
			logger.debug("deletecourseenabler is executed!");
		}

		return "redirect:/managecourseenabler";
	}

	// Delete course by admin
	@RequestMapping(value = "/deletecourseadmin", method = RequestMethod.POST)
	public String deletecourseadmin(@RequestParam("c_id") String c_id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		this.courseService.deletecourseenabler(c_id);

		if (logger.isDebugEnabled()) {
			logger.debug("deletecourseadmin is executed!");
		}

		return "redirect:/managecourseadmin";
	}

	// Deleting enabler by e_id
	@RequestMapping(value = "/deleteenabler", method = RequestMethod.POST)
	public ModelAndView deleteenabler(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String e_id = request.getParameter("e_id");
		String message = this.enablerService.deleteenabler(e_id);

		if (logger.isDebugEnabled()) {
			logger.debug("deleteenabler is executed!");
		}

		return new ModelAndView("admin_home", "message", message);
	}

	// Deleting learner by l_id
	@RequestMapping(value = "/deletelearner", method = RequestMethod.POST)
	public ModelAndView deletelearner(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String l_id = request.getParameter("l_id");
		System.out.println(l_id);
		String message = this.learnerService.deletelearner(l_id);

		if (logger.isDebugEnabled()) {
			logger.debug("deletelearner is executed!");
		}

		return new ModelAndView("admin_home", "message", message);
	}

	// List of courses for learner
	@RequestMapping(value = "/viewcourselearner", method = RequestMethod.GET)
	public ModelAndView viewcourselearner(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Course> courses = this.courseService.viewcourse();
		// System.out.println(courses);

		if (logger.isDebugEnabled()) {
			logger.debug("viewcourselearner is executed!");
		}

		return new ModelAndView("viewcourselearner", "courses", courses);
	}

	// List of courses for enabler
	@RequestMapping(value = "/viewcourseenabler", method = RequestMethod.GET)
	public ModelAndView viewcourseenabler(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Course> courses = this.courseService.viewcourse();
		// System.out.println(courses);

		if (logger.isDebugEnabled()) {
			logger.debug("viewcourseenabler is executed!");
		}

		return new ModelAndView("viewcourseenabler", "courses", courses);
	}

	// List of courses for admin
	@RequestMapping(value = "/viewcourseadmin", method = RequestMethod.GET)
	public ModelAndView viewcourseadmin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Course> courses = this.courseService.viewcourse();
		// System.out.println(courses);

		if (logger.isDebugEnabled()) {
			logger.debug("viewcourseadmin is executed!");
		}

		return new ModelAndView("viewcourseadmin", "courses", courses);
	}

	// Login processing for learner
	@RequestMapping(value = "/loginprocesslearner", method = RequestMethod.POST)
	public ModelAndView loginlearner(HttpServletRequest request,
			HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// HttpSession session = request.getSession();
		session = request.getSession();
		session.setAttribute("username", username);

		boolean b = this.learnerService.verifyUser(username, password);
		System.out.println(b);
		if (b == true) {

			// logs debug message
			if (logger.isDebugEnabled()) {
				logger.debug("learner_home is reached!");
			}

			String message = "";
			// message=(String) session.getAttribute(username);

			if (logger.isDebugEnabled()) {
				logger.debug("loginprocesslearner is executed!");
			}

			return new ModelAndView("learner_home", "message", message);

		} else {

			String message = "Login failed !  " + "Enter correct credentials";

			if (logger.isDebugEnabled()) {
				logger.debug("Error in loginprocesslearner, invalid credentials!");
			}

			return new ModelAndView("loginlearner", "message", message);

		}

	}

	// Login processing for enabler
	@RequestMapping(value = "/loginprocessenabler", method = RequestMethod.POST)
	// @RequestMapping("/loginprocessenabler")
	public ModelAndView loginenabler(HttpServletRequest request,
			HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// HttpSession session = request.getSession();
		session = request.getSession();
		session.setAttribute("username", username);

		String e_id = this.enablerService.enablerdetails(username);

		session.setAttribute("e_id", e_id);

		boolean b = this.enablerService.verifyEnabler(username, password);
		System.out.println(b);
		if (b == true) {

			String message = "";

			if (logger.isDebugEnabled()) {
				logger.debug("loginprocessenabler is executed!");
			}

			return new ModelAndView("enabler_home", "message", message);

		} else {

			String message = "Login failed !  " + "Enter correct credentials";

			if (logger.isDebugEnabled()) {
				logger.debug("Error in loginprocessenabler, invalid credentials!");
			}

			return new ModelAndView("loginenabler", "message", message);

		}

	}

	// Login processing for admin
	@RequestMapping(value = "/loginprocessadmin", method = RequestMethod.POST)
	public ModelAndView loginadmin(HttpServletRequest request,
			HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// HttpSession session = request.getSession();
		session = request.getSession();
		session.setAttribute("username", username);

		System.out.println("hi to login");

		boolean b = this.adminService.verifyAdmin(username, password);
		System.out.println(b);
		if (b == true) {

			String message = "";

			if (logger.isDebugEnabled()) {
				logger.debug("loginprocessadmin is executed!");
			}

			return new ModelAndView("admin_home", "message", message);

		} else {

			String message = "Login failed !  " + "Enter correct credentials";

			if (logger.isDebugEnabled()) {
				logger.debug("Error in loginprocessadmin, invalid credentials!");
			}

			return new ModelAndView("loginadmin", "message", message);

		}
	}

	// for viewing complete course details
	@RequestMapping(value = "/coursedetails", method = RequestMethod.POST)
	public ModelAndView coursedetails(@RequestParam("c_id") String c_id) {

		Course course = this.courseService.details(c_id);
		System.out.println(course);
		// return "redirect:/coursedetails";

		if (logger.isDebugEnabled()) {
			logger.debug("coursedetails is executed!");
		}

		return new ModelAndView("coursedetails", "course", course);

	}

	// for redirecting to login page of learner
	@RequestMapping(value = "/loginpagelearner", method = RequestMethod.GET)
	public ModelAndView loginpagelearner() {
		String message = "";
		return new ModelAndView("loginlearner", "message", message);
	}

	// for redirecting to login page of enabler
	@RequestMapping(value = "/loginpageenabler", method = RequestMethod.GET)
	public ModelAndView loginpageenabler() {
		String message = "";
		return new ModelAndView("loginenabler", "message", message);
	}

	// for redirecting to login page of admin
	@RequestMapping(value = "/loginpageadmin", method = RequestMethod.GET)
	public ModelAndView loginpageadmin() {
		String message = "";
		return new ModelAndView("loginadmin", "message", message);
	}

	// for redirecting to register page of learner
	@RequestMapping(value = "/registerpagelearner", method = RequestMethod.GET)
	public ModelAndView registerpagelearner() {
		String message = "";
		return new ModelAndView("registerlearner", "message", message);
	}

	// for redirecting to register page of enabler
	@RequestMapping(value = "/registerpageenabler", method = RequestMethod.GET)
	public ModelAndView registerpageenabler() {
		String message = "";
		return new ModelAndView("registerenabler", "message", message);
	}

	// for redirecting to addcourse page
	@RequestMapping(value = "/gotoaddcourse", method = RequestMethod.GET)
	public ModelAndView gotoaddcourse() {
		String message = "";
		return new ModelAndView("addcourse", "message", message);
	}

	// for redirecting to contact homepage
	@RequestMapping(value = "/contactpagehome", method = RequestMethod.GET)
	public ModelAndView contactpagehome() {
		String message = "";
		return new ModelAndView("contacthome", "message", message);
	}

	// for redirecting to contact page for enabler
	@RequestMapping(value = "/contactpageenabler", method = RequestMethod.GET)
	public ModelAndView contactpageenabler() {
		String message = "";
		return new ModelAndView("contactenabler", "message", message);
	}

	// for redirecting to contact page for learner
	@RequestMapping(value = "/contactpagelearner", method = RequestMethod.GET)
	public ModelAndView contactpagelearner() {
		String message = "";
		return new ModelAndView("contactlearner", "message", message);
	}

	// for redirecting to learner homepage
	@RequestMapping(value = "/learner_home", method = RequestMethod.GET)
	public ModelAndView learner_home() {
		String message = "";
		return new ModelAndView("learner_home", "message", message);
	}

	// for redirecting to enabler homepage
	@RequestMapping(value = "/enabler_home", method = RequestMethod.GET)
	public ModelAndView enabler_home() {
		String message = "";
		return new ModelAndView("enabler_home", "message", message);
	}

	// for redirecting to admin homepage
	@RequestMapping(value = "/admin_home", method = RequestMethod.GET)
	public ModelAndView admin_home() {
		String message = "";
		return new ModelAndView("admin_home", "message", message);
	}

	// for redirecting to learner's reset password page
	@RequestMapping(value = "/resetpswdlearner", method = RequestMethod.GET)
	public ModelAndView resetpswdlearner() {
		String message = "";
		return new ModelAndView("resetpswdlearner", "message", message);
	}

	// for reseting learner password
	@RequestMapping(value = "/resetprocesslearner", method = RequestMethod.POST)
	public ModelAndView resetprocesslearner(HttpServletRequest request,
			HttpServletResponse response) {

		// String e_username=request.getParameter("username");
		String username = (String) session.getAttribute("username");
		String newpassword = request.getParameter("newpassword");

		String message = this.learnerService.reset(username, newpassword);

		if (logger.isDebugEnabled()) {
			logger.debug("resetprocesslearner is executed!");
		}

		return new ModelAndView("learner_home", "message", message);
	}

	// for redirecting to enabler's reset password page
	@RequestMapping(value = "/resetpswdenabler", method = RequestMethod.GET)
	public ModelAndView resetpswdenabler() {
		String message = "";
		return new ModelAndView("resetpswdenabler", "message", message);
	}

	// for reseting enabler password
	@RequestMapping(value = "/resetprocessenabler", method = RequestMethod.POST)
	public ModelAndView resetprocessenabler(HttpServletRequest request,
			HttpServletResponse response) {

		// String e_username=request.getParameter("username");
		String username = (String) session.getAttribute("username");
		String newpassword = request.getParameter("newpassword");

		String message = this.enablerService.reset(username, newpassword);

		if (logger.isDebugEnabled()) {
			logger.debug("resetprocessenabler is executed!");
		}

		return new ModelAndView("enabler_home", "message", message);
	}

	// for redirecting to admin's reset password page
	@RequestMapping(value = "/resetpswdadmin", method = RequestMethod.GET)
	public ModelAndView resetpswdadmin() {
		String message = "";
		return new ModelAndView("resetpswdadmin", "message", message);
	}

	// for reseting admin password
	@RequestMapping(value = "/resetprocessadmin", method = RequestMethod.POST)
	public ModelAndView resetprocessadmin(HttpServletRequest request,
			HttpServletResponse response) {

		// String e_username=request.getParameter("username");
		String username = (String) session.getAttribute("username");
		String newpassword = request.getParameter("newpassword");

		String message = this.adminService.reset(username, newpassword);

		if (logger.isDebugEnabled()) {
			logger.debug("resetprocessadmin is executed!");
		}

		return new ModelAndView("admin_home", "message", message);
	}

	// Learner's logout
	@RequestMapping(value = "/logoutlearner", method = RequestMethod.GET)
	public ModelAndView logoutlearner(HttpServletRequest request,
			HttpServletResponse response) {

		String message = this.learnerService.logoutlearner(request, response);
		// String message="Successfully logged out";

		if (logger.isDebugEnabled()) {
			logger.debug("logoutlearner is executed!");
		}

		return new ModelAndView("index", "message", message);
	}

	// Enabler's logout
	@RequestMapping(value = "/logoutenabler", method = RequestMethod.GET)
	public ModelAndView logoutenabler(HttpServletRequest request,
			HttpServletResponse response) {

		String message = this.enablerService.logoutenabler(request, response);
		// String message="Successfully logged out";
		System.out.println(message);

		if (logger.isDebugEnabled()) {
			logger.debug("logoutenabler is executed!");
		}

		return new ModelAndView("index", "message", message);
	}

	// Admin's logout
	@RequestMapping(value = "/logoutadmin", method = RequestMethod.GET)
	public ModelAndView logoutadmin(HttpServletRequest request,
			HttpServletResponse response) {

		String message = this.adminService.logoutadmin(request, response);
		// String message="Successfully logged out";

		if (logger.isDebugEnabled()) {
			logger.debug("logoutadmin is executed!");
		}

		return new ModelAndView("index", "message", message);
	}

	// redirection to homepage
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {

		if (logger.isDebugEnabled()) {
			logger.debug("home is executed!");
		}

		String message = "";
		return new ModelAndView("index", "message", message);
	}

}