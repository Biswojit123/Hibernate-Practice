package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.PhPayServices;

public class PartialUpdateRecord {

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
			//Check the record is present or not
			PhPayServices services = session.get(PhPayServices.class, 1);
			if (services == null) {
				System.out.println("Record is not Present");
			} else {
				// set the auto commit off in the database
				transaction = session.beginTransaction();
				
				// Create the object to set the every thing to the perform the update operation
				services.setToMobile(55000.0);
				services.setToSelf(231456253);
				// Update the record
				session.update(services);

				// set the auto commit true
				transaction.commit();

				// print the success
				System.out.println("Record Update Successfully!");
			}

		} catch (Exception e) {
			if (transaction != null && transaction.getStatus() != null) {
				transaction.rollback();
				System.out.println("Record is not present");
			}
			e.printStackTrace();
		}

	}

}