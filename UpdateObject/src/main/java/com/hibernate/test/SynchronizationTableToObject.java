package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.PhPayServices;

public class SynchronizationTableToObject {

	public static void main(String[] args) {
		// Bootstrapping the HiberNate jars
		Configuration config = new Configuration();

		// pass the configuration file
		config.configure("com/hibernate/config/hibernate.cfg.xml");

		// Build the session factory object to specify configuration file services
		SessionFactory factory = config.buildSessionFactory();

		// Create the session object
		Session session = factory.openSession();

		try (factory; session) {
			// load the record from the database table
			PhPayServices services = session.get(PhPayServices.class, 1);
			if (services == null) {
				System.out.println("Record is not avialable");
				return;
			} else {
				System.out.println("Previously object"+services);
				System.out.println(
						"no we have to changes in the database level then it reflected to the objecte level in given below...concept");
				// Now we have to call sleep method
				Thread.sleep(50000);
				//at the time of sleep we have to going database table and changes in the 50 second duration.
				//That reflect to the object level
				session.refresh(services);
				System.out.println("After Changes in database table object is:"+services);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
