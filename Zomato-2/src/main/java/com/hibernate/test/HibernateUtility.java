package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Utility class
public class HibernateUtility {
	
	//private Member
	private static SessionFactory factory;
	
	//Take a static block
	static {
		//Take the Configuration Class
		Configuration config = new Configuration();
		//set the Configuration file
		config.configure("com/hibernate/config/hibernate.cfg.xml");
		//build the Session Factory object
		factory = config.buildSessionFactory();
	}
	
	//get the session object
	public static Session getSessionObject() {
		//Get the Session object
		return factory.openSession();
	}
	
	//get the Session factory object 
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
