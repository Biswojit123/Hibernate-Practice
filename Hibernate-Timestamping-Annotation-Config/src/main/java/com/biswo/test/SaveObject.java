package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.biswo.entity.Stuck;
import com.biswo.utility.HibernateUtility;

//Object save and here implement the time stamp concept 
public class SaveObject {

	public static void main(String[] args) {
		//get the session factory object
		SessionFactory factory = HibernateUtility.getSessionFactory();
		//get the Session object
		Session session = HibernateUtility.getSessionObj();
		//get the Transaction object
		Transaction tra = null;
		try(factory;session) {
			//begin the transaction
			tra = session.beginTransaction();
			//Create the Stuck object
			Stuck stuck = new Stuck("TCS",75.8,"BRS");
			//save the object
			Integer idValue = (Integer) session.save(stuck);
			//commit the transaction
			tra.commit();
			System.out.println("Save object / record by id value:"+idValue);
			System.out.println("Save object / record first time at:"+stuck.getLucnchTime());
			System.out.println("Save object / record last time at:"+stuck.getLastUpdateTime());
		}//end of try
		catch(HibernateException e) {
			if(tra != null || tra.getStatus() != null || tra.getRollbackOnly()) {
				tra.rollback();
				System.out.println("Object is not saved....");
			}
			e.printStackTrace();
		}//end of catch

	}//end of main

}//end of class
