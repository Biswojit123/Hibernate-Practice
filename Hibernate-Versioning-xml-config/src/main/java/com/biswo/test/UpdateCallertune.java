package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.biswo.entity.Callertune;
import com.biswo.util.HibernateUtility;

//Caller tune update
public class UpdateCallertune {
	
	public static void main(String []rags) {
		//get the Session factory object 
		SessionFactory factory = HibernateUtility.getSessionFactoryObj();
		//get the session object
		Session session = HibernateUtility.getSessionObject();
		//set the transaction object 
		Transaction tra = null;
		try(factory;session) {
			//Load the Record from the DB-Table
			Callertune calltune = session.get(Callertune.class,1);
			//check the condition
			if(calltune == null) {
				System.out.println("Record is not found!!!!");
				return;
			}else {
				//begin the transaction 
				tra = session.beginTransaction();
				//update the caller-tune
				calltune.setTune("Srivali");
				//update object
				session.update(calltune);
				//set the auto transaction
				tra.commit();
				System.out.println("Object update successfully "+calltune.getUpdationCount()+"..times");
			}
			
		}//end of try
		catch(HibernateException e) {
			if(tra != null || tra.getStatus() != null || tra.getRollbackOnly()) {
				tra.rollback();
				System.out.println("Object not updated ther is some problem occur...");
			}//end if
			e.printStackTrace();
		}//end catch
	}//end main
}//end class
