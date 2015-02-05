package com.sogeti.registration.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sogeti.registration.beans.User;
import com.sogeti.registration.beans.UserEvent;
import com.sogeti.registration.hibernate.HibernateUtil;

public class UserEventService {
	
	public List<UserEvent> getUserEvents() throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createCriteria(UserEvent.class).list();
 		}
		finally {
			session.close();
		}
	}
	
	public UserEvent getUserEvent(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			UserEvent userEvent = (UserEvent) session.get(UserEvent.class, id);
			return userEvent;
 		}
		finally {
			session.close();
		}
	}
}
