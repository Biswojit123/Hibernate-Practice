package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Locker;

public class GetObject {

	public static void main(String[] args) {
		//Bootstrapping the Hibernate jars
		Configuration config = new Configuration();
		
		//Configure the xml file to the configuration
		config.configure("com/hibernate/config/hibernate.cfg.xml");
		
		//Build the Session Factory object 
		SessionFactory factory = config.buildSessionFactory();
		
		//Create the session object
		Session session = factory.openSession();
		
		//We don't create the Transaction object because we don't changes to the data base object
		try(factory;session) {
			//Here we pass the Class Instantiation that having locker class
			Locker locker = session.get(Locker.class, 1);
			
			//Check the locker is present or not
			if(locker == null) {
				System.out.println("Record not found!!");
			}else {
				System.out.println("Record is present::"+locker);
			}
			//Close the open resources automatically
		}catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Internal server error occur!!");
		}

	}

}
