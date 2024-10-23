package com.biswo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.biswo.entity.Stuck;
import com.biswo.utility.HibernateUtility;

public class UpdateObject {

	public static void main(String[] args) {
		//get the Session factory object 
		SessionFactory factory = HibernateUtility.getSessionFactory();
		//get the session object
		Session session = HibernateUtility.getSessionObj();
		//get the transaction Object
		Transaction tra = null;
		try(factory;session) {
			//load the object
			Stuck stuck = session.load(Stuck.class,2);
			//check the condition
			if(stuck == null) {
				System.out.println("Record is not found.....");
				return;
			}else {
				//other wise began the transaction
				tra = session.beginTransaction();
				//modify the load object
				stuck.setPrice(89.25);
				//update the object
				session.update(stuck);
				//commit the transaction
				tra.commit();
				//print the last time update
				System.out.println("Object or record first time updated at:"+stuck.getLucnchTime());
				System.out.println("Object or record last time updated at:"+stuck.getLastUpdateTime());
				System.out.println("Object updated "+stuck.getUpdationCount()+" times");
			}
		}//end of try
		catch(Exception e) {
			if(tra != null || tra.getStatus() != null || tra.getRollbackOnly())  {
				tra.rollback();
				System.out.println("Object or record is not saved");
			}
			e.printStackTrace();
		}//end of catch
	}//end of main

}//end of class
