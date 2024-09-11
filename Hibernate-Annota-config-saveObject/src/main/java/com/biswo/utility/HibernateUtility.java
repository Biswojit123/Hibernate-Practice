package com.biswo.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Utility class
public class HibernateUtility {
	//private member
	private static SessionFactory factory;
	//i want the create the object for session Factory class at time of loading present class
	//so i declare the logic in static block
	static {
		//Create the Configuration object
		Configuration config = new Configuration();
		
		//Pass the Configure file to the configuration object
		config.configure("com/biswo/config/hibernate.cfg.xml");
		
		//Build the session factory object
		factory = config.buildSessionFactory();
		
	}
	//now get the session factory object
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	//Now get the session object
	public static Session getSession() {
		Session ses = null;
		//check condition if the factory object present then create the session object
		if(factory != null) 
			ses = factory.openSession();
		//return session object
		return ses;
		
	}
}
