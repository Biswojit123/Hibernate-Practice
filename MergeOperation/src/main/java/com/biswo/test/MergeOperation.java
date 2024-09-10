package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.biswo.entity.Locker;

//This program over come the Exception case 
public class MergeOperation {

	public static void main(String[] args) {
		
		//Bootstrapping the HiberNate 
		Configuration config = new Configuration();
		
		//configure the file
		config.configure("com/biswo/config/hibernate.cfg.xml");
		
		//get the Session Factory object or build the session factory that contain the all resources
		SessionFactory factory = config.buildSessionFactory();
		
		//Get the Session object
		Session session = factory.openSession();
		
		//Take the Transaction object
		Transaction tax = null;
		boolean flag = false;
		
		try {
			//Begin the transaction
			tax = session.beginTransaction();//set auto set false in database
			//First the load the object to the Catch first level
			Locker locker = session.load(Locker.class, 2);
			//check the locker record is present or not
			if(locker != null)
				System.out.println("record is present"+locker);
			
			//if present update the record in same object
			Locker locker1 = new Locker();
			locker1.setLockerId(2);
			locker1.setLockerName("Digital-Locker");
			locker1.setLockerPass("Bishnu345");
			locker1.setPerson("Gagan Palei");
			System.out.println("125");
			//update the object that present in the catch of same id
			Locker locker2 = (Locker) session.merge(locker1);
			System.out.println(locker2);
			
			System.out.println("Record Update successfully!");
			flag = true;
			
		}catch(HibernateException e) {
			flag = false;
			e.printStackTrace();
		}finally {
			if(flag) {
				tax.commit();
			}else {
				tax.rollback();
				System.out.println("Record is not updated!");
			}
		}

	}

}
