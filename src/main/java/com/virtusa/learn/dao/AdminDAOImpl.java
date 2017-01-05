package com.virtusa.learn.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.virtusa.learn.controller.HelloController;

@Repository
public class AdminDAOImpl implements AdminDAO {

	private static final Logger logger = Logger
			.getLogger(AdminDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// admin's login process
	public boolean verifyAdmin(String username, String password) {
		logger.info("verifyAdmin is executed!");
		Session session = sessionFactory.openSession();
		boolean status = false;
		try {
			String SQL_QUERY = " from Admin as a where a.a_username=? and a.a_password=?";
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

	// admin's password reset
	public String reset(String username, String newpassword) {
		logger.info("reset is executed!");
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session
				.createQuery("update Admin set a_password = :newpassword"
						+ " where a_username = :username");
		query.setParameter("username", username);
		query.setParameter("newpassword", newpassword);
		query.executeUpdate();
		return "Password changed successfully";

	}

	// admin's logout
	public String logoutadmin(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("logout is executed!");
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "Logout successfull";
	}

}
