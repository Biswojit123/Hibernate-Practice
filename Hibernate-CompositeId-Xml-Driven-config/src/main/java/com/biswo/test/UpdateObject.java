package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.biswo.entity.ProgrammerId;
import com.biswo.entity.ProgrammerProjectInfo;
import com.biswo.util.HibernateUtility;

public class UpdateObject {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//get the Session factory object
		SessionFactory factory = HibernateUtility.getSessionFactory();
		//get the Session object
		Session session = HibernateUtility.getSession();
		//set the Transaction 
		Transaction tra = null;
		try(factory;session) {
			//load the object is present or not
			//First we have to create the object of programmerId object
			ProgrammerId progrmId = new ProgrammerId(102,253);
			//create the ProgrammerProjectInfo
			ProgrammerProjectInfo programInfo = session.load(ProgrammerProjectInfo.class, progrmId);
			if(programInfo == null) {
				System.out.println("Record is not present..");
			}else {
				//set the transaction is commit off
				tra = session.beginTransaction();
				programInfo.setBudget(29000000.0);
				programInfo.setSalary(29000.0);
				session.update(programInfo);
				tra.commit();
				System.out.println("Object Update Successfully.....");
			}//end else
		}//end try
		catch(HibernateException e) {
			if(tra != null || tra.getStatus() != null || tra.getRollbackOnly()) {
				tra.rollback();
				System.out.println("Object not updated....");
			}//end if
			e.printStackTrace();
		}//end catch

	}//end main

}//end class
