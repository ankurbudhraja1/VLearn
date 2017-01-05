package com.virtusa.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.learn.dao.CourseDAO;
import com.virtusa.learn.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	// adding a course
	@Transactional
	public void save(Course course) {
		this.courseDAO.save(course);
	}

	// List of courses
	@Transactional
	public List<Course> viewcourse() {
		return this.courseDAO.viewcourse();
	}

	// List of enabler's courses
	@Transactional
	public List<Course> managecourseenabler(String e_id) {
		return this.courseDAO.managecourseenabler(e_id);
	}

	// List of all courses for admin view
	@Transactional
	public List<Course> managecourseadmin() {
		return this.courseDAO.managecourseadmin();
	}

	// downloading course materials
	@Transactional
	public Course download(String c_id) {
		return this.courseDAO.download(c_id);
	}

	// Delete enabler's courses
	@Transactional
	public String deletecourseenabler(String c_id) {
		return this.courseDAO.deletecourseenabler(c_id);
	}

	// Fetching course details
	@Transactional
	public Course details(String c_id) {
		return this.courseDAO.details(c_id);
	}
}
