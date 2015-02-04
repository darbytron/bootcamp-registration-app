package com.sogeti.registration.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

//import antlr.debug.Event;

import com.sogeti.registration.beans.User;
import com.sogeti.registration.beans.Event;
import com.sogeti.registration.hibernate.HibernateUtil;

public class EventService 
{

	public List<Event> getEvents() throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createCriteria(Event.class).list();
 		}
		finally {
			session.close();
		}
	}
	
	public Event getEvent(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Event event = (Event) session.get(Event.class, id);
			return event;
 		}
		finally {
			session.close();
		}
	}
	
	public void deleteEvent(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Event event = (Event) session.get(Event.class, id);
			Transaction t = session.beginTransaction();
			session.delete(event);
			t.commit();		
			session.flush();
 		}
		finally {
			session.close();
		}
	}
	
	
	
	
	
	
	
	
	
	public List<User> getUsersForEvent(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			Criteria criteria = session.createCriteria(Event.class, "l");
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
