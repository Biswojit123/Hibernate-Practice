package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Locker;

public class SaveObject {

	public static void main(String[] args) {
		//Bootstrap or hibernate Activate
		Configuration config = new Configuration();
		
		//Specify the hibernate configuration file 
		config.configure("com/hibernate/config/hibernate.cfg.xml");
		
		//Build the session factory object that specify the all property and resources
		SessionFactory factory = config.buildSessionFactory();
		
		//Create the session object for bridge between the hibernate frame work and java application
		Session session = factory.openSession();
		
		//Create the Transaction object for accuracy maintain in data base
		Transaction tax = null;
		
		try {
			//it internally call the con.setAutocommit(false) so it disable the auto commit in database
			tax = session.beginTransaction();
			
			//Create the Object
			Locker locker = new Locker();
			
			locker.setLockerId(1256354);
			locker.setLockerName("Digital-Locker");
			locker.setLockerPass("Pinkun@123");
			locker.setPerson("Pinkun Palei");
	
			//Save the object
			Integer lockerId = (Integer) session.save(locker);
			
			//Return generated order id
			System.out.println("Genereted Order Id ::"+lockerId);
			
			//set the auto commit
			tax.commit();
			
			//print the object
			System.out.println("Object inserted successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			tax.rollback();
			System.out.println("Object is not saved(Record is not inserted)");
		}finally {
			//close the all resources
			session.close();
			factory.close();
		}//end final

	}//end main

}//end class
