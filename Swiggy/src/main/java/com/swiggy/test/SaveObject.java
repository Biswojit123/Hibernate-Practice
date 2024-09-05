package com.swiggy.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.swiggy.entity.Product;

public class SaveObject {

	public static void main(String[] args) {
		// Bootstrap or hibernate activate
		Configuration config = new Configuration();

		// Specify the hibernate Configuration file
		config.configure("com/swiggy/config/hibernate.cfg.xml");

		// Build the session factory object that specify the configuration file and many
		// other resources
		SessionFactory factory = config.buildSessionFactory();

		// Create the Session object for the bridge between the application and
		// hibernate framework
		Session session = factory.openSession();

		// Create the Transaction Object throw that we have save the accurate object
		Transaction tax = null;

		try {
			// set the auto commit off
			tax = session.beginTransaction();// Internally call the con.setautoCommit(false) disable the commit operation on the database
			
			//Create the object
			Product product = new Product();
			product.setDescription("This is the latest product");
			product.setName("FireBolt");
			product.setPrice(25000.0);
			product.setProductId(100);
			product.setQty(2);
			
			//Save object and return the id
			Integer productId = (Integer) session.save(product);
			System.out.println("Saveed object id:"+productId);
			
			//Set the auto commit
			tax.commit();
			
			//Print the 
			System.out.println("Object Inserted Successfully");
		} catch (HibernateException he) {
			he.printStackTrace();
			tax.rollback();
			System.out.println("Object is not Inserted ...error..aries");
		} finally {
			//close the resources
			session.close();
			factory.close();
		}

	}// end of main

}// end of class
