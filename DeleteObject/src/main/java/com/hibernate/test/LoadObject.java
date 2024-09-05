package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.PhPayServices;

public class LoadObject {

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
			// Return the proxy-Object
			PhPayServices services = session.load(PhPayServices.class, 1);

			System.out.println(services.getClass());
			// Print the every thing (this is the all non-identifier method operation on
			// proxy-object so it interact with the Database when required
			System.out.println(services.getRecharge() + "..." + services.getTraName() + "..." + services.getToMobile()
					+ "..." + services.getToSelf() + "..." + services.getTransactionId());
		}catch(HibernateException he) {
			System.out.println("Record is not found");
			he.printStackTrace();
		}

	}

}
