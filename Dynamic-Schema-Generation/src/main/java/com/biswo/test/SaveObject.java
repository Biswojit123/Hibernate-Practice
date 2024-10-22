package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.biswo.entity.Account;

public class SaveObject {

	public static void main(String[] args) {
		//Bootstrapping the HiberNate 
		Configuration config = new Configuration();
		//Configure the Configuration file 
		config.configure("com/biswo/config/hibernate.cfg.xml");
		//Build the session factory object
		SessionFactory factory = config.buildSessionFactory();
		//Build the session object
		Session session = factory.openSession();
		//Create the Transaction object that accuracy maintain in the Database
		Transaction transaction = null;
		
		try(factory;session) {
			//Began the transaction
			transaction = session.beginTransaction();
			//Create the object that to store in  the database
			Account acc = new Account(5646464,"Manas Palei",25000.0,"Temporary Account");
			//Save Object 
			Integer id = (Integer) session.save(acc);
			System.out.println("Object id  is::"+id);
			//Commit the object
			transaction.commit();
			System.out.println("Object saved Successfully!!!");
		}catch(HibernateException e) {
			//roll-back when any error occur
			if(transaction != null && transaction.getStatus() != null && transaction.getRollbackOnly()) {
				transaction.rollback();
				System.out.println("Object not saved successfully!!!");
			}
			e.printStackTrace();
		}//end of catch block

	}//end of main method

}//end of class
