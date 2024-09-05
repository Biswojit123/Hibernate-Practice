package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.PhPayServices;

public class InsertRecord {

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
		
		try(factory;session) {
			//set the auto commit off in database level
			transaction = session.beginTransaction();
			//Create the object and set the value to insert
			PhPayServices ph = new PhPayServices();
			ph.setRecharge("success");
			ph.setToMobile(20000.0);
			ph.setToSelf(2312356);
			ph.setTraName("UPI-Transction");
			ph.setTransactionId(1230562);
			
			//Insert record
			Integer transactionId = (Integer) session.save(ph);
			
			//print the id
			System.out.println("Transaction id is::"+transactionId);
			
			//set the auto-commit here every thing will happen
			transaction.commit();
			
			//print the success or not the transaction
			System.out.println("Transaction Success");
		}catch(HibernateException he) {
			he.printStackTrace();
			if(transaction != null && transaction.getStatus() != null) {
				System.out.println("Record is not inserted");
				transaction.rollback();
			}
		}

	}

}
