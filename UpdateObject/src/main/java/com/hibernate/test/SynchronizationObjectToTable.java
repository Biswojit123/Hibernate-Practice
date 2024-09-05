package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.PhPayServices;

public class SynchronizationObjectToTable {

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
			// load the record from the database table
			PhPayServices services = session.get(PhPayServices.class, 1);
			if (services == null) {
				System.out.println("Record is not avialable");
				return;
			} else {
				// set the Auto commit off in database level
				transaction = session.beginTransaction();
				// here we set the value to the object
				services.setTraName("Online-Payment");
				services.setToMobile(29300.0);
				// without performing update operation automatically changes happen in table
				// level that is the Object to database Synchronization.
				// transaction commit
				transaction.commit();
				System.out.println("Record Updated successfully!");
			}
		} catch (Exception e) {
			if(transaction != null && transaction.getStatus() != null) {
				transaction.rollback();
				System.out.println("In record no any changes Happen");
			}
			e.printStackTrace();
		}

	}

}
