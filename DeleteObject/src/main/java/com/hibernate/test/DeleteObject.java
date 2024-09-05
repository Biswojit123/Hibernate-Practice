package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.PhPayServices;

public class DeleteObject {

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
			// set the auto commit off in the database
			transaction = session.beginTransaction();
			//Create the object
			PhPayServices services = new PhPayServices();
			services.setTransactionId(1);//this id must present in the data base table other wise give exception
			//Set the id you want to delete
			session.delete(services);
			
			transaction.commit();

			// print the success
			System.out.println("Record Delete Successfully!");
		} catch (Exception e) {
			if (transaction != null && transaction.getStatus() != null) {
				transaction.rollback();
				System.out.println("Record is not present");
			}
			e.printStackTrace();
		}

	}

}
