package com.virtusa.learn.dao;

import java.io.FileOutputStream;
import java.sql.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.virtusa.learn.model.*;

@Repository
public class LearnerDAOImpl implements LearnerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public boolean addLearner(Learner p) {
		Session session = this.sessionFactory.getCurrentSession();
		String username = p.getL_username();
		Query q = session
				.createQuery(
						"select l.l_username from Learner l where l.l_username= :username")
				.setString("username", username);
		List list = q.list();

		if (!list.isEmpty()) {
			return false;
		}
		session.save(p);
		return true;

	}

	// Learner's password reset
	public String reset(String username, String newpassword) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session
				.createQuery("update Learner set l_password = :newpassword"
						+ " where l_username = :username");
		query.setParameter("username", username);
		query.setParameter("newpassword", newpassword);
		query.executeUpdate();
		return "Password changed successfully";
	}

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// Learner login
	public boolean verifyUser(String username, String password) {
		Session session = sessionFactory.openSession();
		boolean status = false;
		try {
			String SQL_QUERY = " from Learner as l where l.l_username=? and l.l_password=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0, username);
			query.setParameter(1, password);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				status = true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		session.close();
		return status;
	}

	// Delete learner
	public String deletelearner(String l_id) {

		Session session = this.sessionFactory.openSession();
		String hql = "DELETE FROM Learner " + "WHERE l_id = :l_id";
		Query query = session.createQuery(hql);
		query.setParameter("l_id", l_id);
		query.executeUpdate();
		session.close();
		return "learner successfully deleted";
	}

	// List of learners
	public List<Learner> listlearners() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Learner.class);
		return (List<Learner>) criteria.list();

	}

	// Learner's logout
	public String logoutlearner(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "Logout successfull";
	}

}
