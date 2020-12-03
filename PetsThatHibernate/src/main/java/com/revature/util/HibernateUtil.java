package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session session;
	
	// Static Initializer
	// Will run when the class is loaded initially
	static {
		sf = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();
	}
	
	private static SessionFactory sf;
		
	private HibernateUtil() {
		super();
	}
	
	public static Session getSession() {
		if(session == null || !session.isOpen()) {
			session = sf.openSession();
		}
		
		return session;
	}
	
	public static void closeSession() {
		if(session != null) {
			session.close();
		}
	}
}