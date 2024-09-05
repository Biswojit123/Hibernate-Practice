package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Locker;

public class SaveOrUpdateWithoutGeneratorAndUnSavedValue {

	public static void main(String[] args) {
		
		//Bootstrapping the Hibernate FrameWork
		Configuration config = new Configuration();
		
		config.configure("com/hibernate/config/hibernate.cfg.xml");
		
		//Build the Session factory object that specify the XML configure all resources
		SessionFactory factory = config.buildSessionFactory();
		
		//Get the Session object for Connection between the Hibernate and client application
		Session session = factory.openSession();
		
		//Set the Transaction
		Transaction transaction = null;
		
		try(factory;session) {
			//set the auto commit off
			transaction = session.beginTransaction();
			//set the object to saving database
			Locker locker = new Locker();
			locker.setLockerId(458);
			locker.setLockerPass("Rakesh@123");
			locker.setPerson("Rakesh Gouda");
			//save or Update operation perform
			session.saveOrUpdate(locker);
			//set Auto commit
			transaction.commit();
			System.out.println("Object saved or updated Successfully");
		}catch(HibernateException he) {
			transaction.rollback();
			System.out.println("Object not saved or Updated");
			he.printStackTrace();
		}

	}

}
