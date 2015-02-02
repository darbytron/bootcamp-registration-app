package com.sogeti.registration.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sogeti.registration.beans.User;
import com.sogeti.registration.hibernate.HibernateUtil;

public class UserService {
	
	public List<User> getUsers() throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createCriteria(User.class).list();
 		}
		finally {
			session.close();
		}
	}
	
	public User getUser(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			User user = (User) session.get(User.class, id);
			return user;
 		}
		finally {
			session.close();
		}
	}
	
	public void deleteUser(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			User user = (User) session.get(User.class, id);
			Transaction t = session.beginTransaction();
			session.delete(user);
			t.commit();		
			session.flush();
 		}
		finally {
			session.close();
		}
	}
}
