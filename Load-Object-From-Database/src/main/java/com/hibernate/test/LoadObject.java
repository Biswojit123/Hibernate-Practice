package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Locker;

public class LoadObject {

	public static void main(String[] args) {
		// Bootstrapping hibernate
		Configuration config = new Configuration();

		// pass the xml configuration file to the configuration object
		config.configure("com/hibernate/config/hibernate.cfg.xml");

		// Build the Session factory object specify the xml configuration file
		SessionFactory factory = config.buildSessionFactory();

		// Get the session object from the session object basically it will use the
		// transfer the object persistence to hibernate framework
		Session session = factory.openSession();

		// Here we use the java 1.9 version concept
		try (factory; session) {
			// here we pass the id to the load method
			Locker locker = session.load(Locker.class, 1);// It return the proxyObject
			// ProxyObject means it is the dummy object that look like real object that
			// internally use the Real object
			// it means in this time that load method is not interact with data base it
			// simple create the dummy object and return it means lazy operation performed
			// if we want to interact with the database then we have to use the that dummy
			// object to interact with the database
			System.out.println(locker.getClass());// here we print the that proxyObject that don't interact with data
													// base
			// if we check the internally use the real object or not we have to check here
			System.out.println(locker.getClass() + " Internal Class is:" + locker.getClass().getSuperclass());
			// from the above implementation there nothing to interact with database
			// if we want interact with the data base only way is we provide the
			// non-identity method operation perform to the dummy object
			//in this below case is use the identity method so it not interact with the database
			System.out.println(locker.getLockerId());//proved
			
			//now we perform the non-identity method to the dummy object
			System.out.println(locker.getLockerName()+"----"+locker.getLockerPass()+"----"+locker.getPerson()+"----"+locker.getLockerId());
		} catch (HibernateException e) {
			System.out.println("Record not found");
			e.printStackTrace();
		}

	}

}
