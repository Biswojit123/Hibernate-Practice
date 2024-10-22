package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.biswo.entity.Callertune;
import com.biswo.util.HibernateUtility;

public class SaveObject {

	public static void main(String[] args) {
		//Get the sessionFactory object
		SessionFactory factory = HibernateUtility.getSessionFactoryObj();
		//get the session object
		Session session = factory.openSession();
		//Set the transaction
		Transaction tra = null;
		
		try(factory;session) {
			//began the transaction
			tra = session.beginTransaction();
			//Create the Object for the CallerTune
			Callertune callerTune = new Callertune();
			callerTune.setMovieName("Puspa");
			callerTune.setTune("O anta ba ma");
			//save the object
			Integer id = (Integer) session.save(callerTune);
			//Set the Auto commit on
			tra.commit();
			System.out.println("Object Saved Successfully..CallerId:"+id);
		}catch(HibernateException e) {
			if(tra != null || tra.getStatus() != null || tra.getRollbackOnly()) {
				tra.rollback();
				System.out.println("Object not saved....");
			}
			e.printStackTrace();
		}//end catch

	}//end main

}//end class
