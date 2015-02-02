package com.sogeti.registration.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sogeti.registration.beans.ToDoItem;
import com.sogeti.registration.hibernate.HibernateUtil;

public class ToDoItemService {
	
	public List<ToDoItem> getToDoItems() throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createCriteria(ToDoItem.class).list();
 		}
		finally {
			session.close();
		}
	}
	
	public ToDoItem getToDoItem(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return (ToDoItem) session.get(ToDoItem.class, id);
 		}
		finally {
			session.close();
		}
	}
	
	public void deleteToDoItem(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			ToDoItem item = (ToDoItem) session.get(ToDoItem.class, id);
			Transaction t = session.beginTransaction();
			session.delete(item);
			t.commit();
			session.flush();
 		}
		finally {
			session.close();
		}
	}
}
