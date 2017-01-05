package com.virtusa.learn.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.virtusa.learn.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	private static final Logger logger = Logger
			.getLogger(CourseDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// adding a course
	public List<Course> viewcourse() {
		logger.info("viewcourse is executed!");
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Course.class);
		return (List<Course>) criteria.list();
	}

	// Delete enabler's courses
	public String deletecourseenabler(String c_id) {
		logger.info("deletecourseenabler is executed!");
		Session session = this.sessionFactory.openSession();
		String hql = "DELETE FROM Course " + "WHERE c_id = :c_id";

		Query query = session.createQuery(hql);
		query.setParameter("c_id", c_id);
		query.executeUpdate();
		session.close();
		return "successfully deleted";
	}

	// List of enabler's courses
	public List<Course> managecourseenabler(String e_id) {
		logger.info("managecourseenabler is executed!");
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Course.class, e_id);
		criteria.add(Restrictions.eq("e_id", e_id));
		return (List<Course>) criteria.list();

	}

	// List of all courses for admin view
	public List<Course> managecourseadmin() {
		logger.info("managecourseadmin is executed!");
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Course.class);
		return (List<Course>) criteria.list();

	}

	// downloading course materials
	public Course download(String c_id) {
		logger.info("download is executed!");
		Session session = this.sessionFactory.openSession();
		Course course = (Course) session.get(Course.class, c_id);
		session.close();
		return course;
	}

	// Fetching course details
	public Course details(String c_id)

	{
		logger.info("details is executed!");
		Session session = this.sessionFactory.openSession();
		Course course = (Course) session.get(Course.class, c_id);
		session.close();
		return course;
	}

	// adding a course
	public void save(Course course) {
		logger.info("save is executed!");
		Session session = this.sessionFactory.getCurrentSession();
		session.save(course);
	}
}
