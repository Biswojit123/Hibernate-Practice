package com.biswo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//This is the factory design pattern
public class HibernateUtility {
	//first to create the session factory object 
	private static SessionFactory factory = null;
	
	//create the static block that 
	static {
		//create the configuration object
		Configuration config = new Configuration();	
		//set the configuration file to the configuration
		config.configure("com/biswo/config/hibernate.cfg.xml");
		//Build the session factory object
		factory = config.buildSessionFactory();
	}
	
	//now create the static method that method when i call that return the session factory object
	public static SessionFactory getSessionFactoryObj() {
		return factory;
	}
	
	//Create the session object through the this method
	public static Session getSessionObject() {
		//create the session object
		Session session = null;
		if(session == null) {
			session = factory.openSession();
		}
		return session;
	}
}
