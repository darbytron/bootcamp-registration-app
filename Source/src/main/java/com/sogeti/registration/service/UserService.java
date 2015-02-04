package com.sogeti.registration.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sogeti.registration.beans.ToDoList;
import com.sogeti.registration.beans.Event;
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
	
	
	
	
	
	
	
	
	public List<User> getEventsForUser(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			Criteria criteria = session.createCriteria(ToDoList.class, "l");
			criteria.createAlias("l.users", "u");
			criteria.add(Restrictions.eq("u.id", id));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			return criteria.list();
 		}
		finally {
			session.close();
		}
	}
	
	
	
	
}
