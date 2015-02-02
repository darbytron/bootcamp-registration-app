package com.sogeti.registration.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * 
 * HibernateUtil
 * The hibernate utility is used to create a session for the hibernate calls to the database.
 * This class also has methods to save or update an object using hibernate.
 *
 * @author Sogeti USA
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static void configureSessionFactory() {
		configureSessionFactory(null);
	}

	public static void configureSessionFactory(String filename) {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = null;
			if (filename == null)
				configuration = new Configuration().configure();
			else
				configuration = new Configuration().configure(filename);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
					applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			configureSessionFactory();
		return sessionFactory;
	}

	public static void saveOrUpdate(Object o) {
		Session s = getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		try{
			s.saveOrUpdate(o);
			t.commit();
		}
		finally{
			s.disconnect();
			s.close();
		}
	}
	
	public static void save(Object o) {
		Session s = getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		try{
			s.save(o);
			t.commit();			
		}
		finally{
			s.disconnect();
			s.close();
		}
	}

	public static void delete(Object o) {
		Session s = getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		try{
			s.delete(o);
			t.commit();			
		}
		finally{
			s.disconnect();
			s.close();
		}

	}	
	
}