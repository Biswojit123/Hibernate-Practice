package com.biswo.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Utility class(Factory design pattern
public class HibernateUtility {
	//Take the session factory object
	private static SessionFactory factory = null;
	//take the static block
	static {
		//create the Configuration Object
		Configuration config = new Configuration();
		//configure the configuration file
		config.configure("com/biswo/config/hibernate.cfg.xml");
		//Build the session factory object
		factory = config.buildSessionFactory();
	}
	//create a static method
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	//get the session object
	public static Session getSessionObj() {
		//create the Session object  
		Session session = null;
		//if session object null then it create the session object
		if(session == null) {
			session = factory.openSession();
		}
		return session;
	}
}
