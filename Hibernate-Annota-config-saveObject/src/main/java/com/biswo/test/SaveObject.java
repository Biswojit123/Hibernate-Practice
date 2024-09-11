package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biswo.entity.Movie;
import com.biswo.utility.HibernateUtility;

public class SaveObject {

	public static void main(String[] args) {
		//Get the Session object
		Session session = HibernateUtility.getSession();
		//Get the Transaction Object
		Transaction tax = null;
		
		//Use the try with resources
		try(session) {
			//Began the transaction 
			tax = session.beginTransaction();
			//Create the object of Movie
			Movie movie = new Movie(12356,"RRR","Ram-Charan",2000000.0);
			//Save object
			Integer mId = (Integer) session.save(movie);
			//print the movie id
			System.out.println("Movie id is::"+mId);
			//commit the transaction
			tax.commit();
			System.out.println("Object saved successfully!!");
		}catch(HibernateException he) {
			if(tax != null && tax.getStatus() != null && tax.getRollbackOnly()) {
				tax.rollback();
				System.out.println("Object Not Saved");
			}
			he.printStackTrace();
		}//end of catch
		

	}//end of main method

}//end of class
