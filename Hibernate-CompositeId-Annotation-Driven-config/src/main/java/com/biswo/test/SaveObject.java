package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.biswo.entity.ProgrammerId;
import com.biswo.entity.ProgrammerProjectInfo;
import com.biswo.util.HibernateUtility;

public class SaveObject {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//get the SessionFactory object
		SessionFactory factory = HibernateUtility.getSessionFactory();
		//get the Session object
		Session session = HibernateUtility.getSession();
		//set the Transaction auto commit off
		Transaction tra = null;
		try(factory;session) {
			tra = session.beginTransaction();
			//Create the object for ProgrammerId 
			ProgrammerId progrmId = new ProgrammerId(102,253);
			//create the object of 
			ProgrammerProjectInfo programmerProj = new ProgrammerProjectInfo(progrmId,"Biswojit jena","Open-Proj",25000.0,900000.0);
			//save that object into the database
			ProgrammerId proId = (ProgrammerId) session.save(programmerProj);
			//commit the object
			tra.commit();
			System.out.println("Object saved successfully:"+proId);
		}//end the try block
		catch(HibernateException e) {
			if(tra != null || tra.getStatus() != null || tra.getRollbackOnly()) {
				tra.rollback();
				System.out.println("Object is not saved some internal error come.....");
			}//end if
			e.printStackTrace();
		}//end catch

	}//end main

}//end class
