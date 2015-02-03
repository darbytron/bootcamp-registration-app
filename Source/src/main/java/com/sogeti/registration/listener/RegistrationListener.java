package com.sogeti.registration.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sogeti.registration.hibernate.HibernateUtil;

public class RegistrationListener implements ServletContextListener {
	private static final String HIBERNATE_CFG_PARAM = "hibernate-cfg";
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		String cfgFile = event.getServletContext().getInitParameter(HIBERNATE_CFG_PARAM);
		HibernateUtil.configureSessionFactory(cfgFile);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

}
