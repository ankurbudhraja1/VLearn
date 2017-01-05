package com.virtusa.learn.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.learn.model.Course;
import com.virtusa.learn.model.Enabler;

@Repository
public class EnablerDAOImpl implements EnablerDAO {
	
	private static final Logger logger = Logger
			.getLogger(EnablerDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;

	}

	// Get enabler details
	@Transactional
	public String enablerdetails(String e_username)

	{
		logger.info("enablerdetails is executed!");
		Session session = this.sessionFactory.openSession();
		String type = (String) session
				.createQuery(
						"select e.e_id from Enabler e where e.e_username = :e_username")
				.setString("e_username", e_username).uniqueResult();
		session.close();
		return type;
	}

	// Enabler's password reset
	public String reset(String username, String newpassword) {
		logger.info("reset is executed!");
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session
				.createQuery("update Enabler set e_password = :newpassword"
						+ " where e_username = :username");
		query.setParameter("username", username);
		query.setParameter("newpassword", newpassword);
		query.executeUpdate();
		return "Password changed successfully";

	}

	// Delete Enabler
	public String deleteenabler(String e_id) {
		logger.info("deleteenabler is executed!");
		Session session = this.sessionFactory.openSession();

		String hql = "DELETE FROM Enabler " + "WHERE e_id = :e_id";

		Query query = session.createQuery(hql);
		query.setParameter("e_id", e_id);
		query.executeUpdate();

		session.close();
		return "enabler successfully deleted";
	}

	// Enabler registration
	public boolean addEnabler(Enabler e) {
		logger.info("addEnabler is executed!");
		Session session = this.sessionFactory.getCurrentSession();
		String username = e.getE_username();
		Query q = session
				.createQuery(
						"select e.e_username from Enabler e where e.e_username= :username")
				.setString("username", username);
		List list = q.list();

		if (!list.isEmpty()) {
			return false;
		}
		session.save(e);
		return true;
	}

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// Enabler login
	public boolean verifyEnabler(String username, String password) {
		logger.info("verifyEnabler is executed!");
		Session session = sessionFactory.openSession();
		boolean status = false;
		try {
			String SQL_QUERY = " from Enabler as e where e.e_username=? and e.e_password=?";
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

	// List of enablers
	public List<Enabler> listenablers() {
		logger.info("listenablers is executed!");
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Enabler.class);
		return (List<Enabler>) criteria.list();
	}

	// Enabler's logout
	public String logoutenabler(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("logoutenabler is executed!");
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "Logout successfull";
	}

}
