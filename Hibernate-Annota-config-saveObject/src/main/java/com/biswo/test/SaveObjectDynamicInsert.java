package com.biswo.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biswo.entity.Movie;
import com.biswo.utility.HibernateUtility;

public class SaveObjectDynamicInsert {

	public static void main(String[] args) {
		
		//Get the Session object
		Session session = HibernateUtility.getSession();
		
		//Transaction begin
		Transaction transaction = null;
		try(session) {
			//begin transaction
			transaction = session.beginTransaction();
			//Create the object 
			Movie movie = new Movie();
			//set the value to the movie dynamically
			movie.setMovieId(12534);
			movie.setMovieHero("Ali-Arjun");
			movie.setMovieName("Puspa");
			//save the object
			session.save(movie);
			//commit the transaction 
			transaction.commit();
			System.out.println("Object saved successfully!!");
		}catch(HibernateException e) {
			if(transaction!=null&&transaction.getStatus()!=null&&transaction.getRollbackOnly()) {
				transaction.rollback();
				System.out.println("Object is not saved");
			}
			e.printStackTrace();
		}catch(Exception e) {
			if(transaction!=null&&transaction.getStatus()!=null&&transaction.getRollbackOnly()) {
				transaction.rollback();
				System.out.println("Object is not saved");
			}
			e.printStackTrace();
		}
	}

}
