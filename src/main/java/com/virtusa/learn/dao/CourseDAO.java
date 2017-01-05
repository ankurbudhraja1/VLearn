package com.virtusa.learn.dao;

import java.util.List;

import com.virtusa.learn.model.Course;

public interface CourseDAO {
	// adding a course
	public void save(Course course);

	// downloading course materials
	public Course download(String c_id);

	// Fetching course details
	public Course details(String c_id);

	// List of courses
	public List<Course> viewcourse();

	// List of enabler's courses
	public List<Course> managecourseenabler(String e_id);

	// List of all courses for admin view
	public List<Course> managecourseadmin();

	// Delete enabler's courses
	public String deletecourseenabler(String c_id);
}
