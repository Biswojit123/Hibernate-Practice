package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveObject {

	public static void main(String[] args) {
		
		//Take the utility class
		Session session = HibernateUtility.getSessionObject();
		//Create the Transaction object for Valid the Acid properties
		Transaction tax = null;
		
		//Use the try catch block for exception handling
		try {
			//it internally call the con.setAutoCommit(false) to disable auto commit mode in database
			tax = session.beginTransaction();
			
			//Create the object
			com.hibernate.entity.Transaction transaction = new com.hibernate.entity.Transaction();
			//set the value to the object
			transaction.setAccountNumber(256314895695l);
			transaction.setAmount(55000.0);
			transaction.setTransctionId("SBI100022145");
			
			//save that object to the data base(internally perform the insertion operation to store the data)
			session.save(transaction);
			
			//after success execution(Internally call the con.commit() for commit record after successful execution)
			tax.commit();
			
			//print a message for successfully execution
			System.out.println("Data Saveed Successfully!!");
			
		}catch(HibernateException he) {
			//throw new RuntimeException("Some error occur in executing level");
			he.printStackTrace();
			tax.rollback();
			System.out.println("Object is not saved(Object is not inserted)");
		}
		
		//close session Object 
		session.close();
	}//Main end

}//class End
