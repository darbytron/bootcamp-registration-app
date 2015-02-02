package com.sogeti.registration.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sogeti.registration.beans.ToDoList;
import com.sogeti.registration.hibernate.HibernateUtil;

public class ToDoListService {
	
	public List<ToDoList> getLists() throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createCriteria(ToDoList.class).list();
 		}
		finally {
			session.close();
		}
	}
	
	public List<ToDoList> getListsForUser(int id) {
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
	
	public ToDoList getList(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return (ToDoList) session.get(ToDoList.class, id);
 		}
		finally {
			session.close();
		}
	}
	
	public void deleteList(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			ToDoList list = (ToDoList) session.get(ToDoList.class, id);
			Transaction t = session.beginTransaction();
			session.delete(list);
			t.commit();
			session.flush();
 		}
		finally {
			session.close();
		}
	}	
}
