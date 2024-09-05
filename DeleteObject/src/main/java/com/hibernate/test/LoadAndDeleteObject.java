package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.PhPayServices;

public class LoadAndDeleteObject {

	public static void main(String[] args) {

		// Bootstrapping the HiberNate jars
		Configuration config = new Configuration();

		// pass the configuration file
		config.configure("com/hibernate/config/hibernate.cfg.xml");

		// Build the session factory object to specify configuration file services
		SessionFactory factory = config.buildSessionFactory();

		// Create the session object
		Session session = factory.openSession();

		// Here we Create the transaction object
		Transaction transaction = null;

		try (factory; session) {
			//get the object from the database table 
			PhPayServices services = session.get(PhPayServices.class, 1230562);
			if(services == null) {
				System.out.println("Record not found");
				return;
			}else {
				//Off auto commit
				transaction = session.beginTransaction();
				//instruct to the delete
				session.delete(services);
				//commit
				transaction.commit();
				// print the success
				System.out.println("Record Delete Successfully!");
			}
		} catch (Exception e) {
			if (transaction != null && transaction.getStatus() != null) {
				transaction.rollback();
				// print the success
				System.out.println("Record Delete Successfully!");
			}
			e.printStackTrace();
		}

	}

}
