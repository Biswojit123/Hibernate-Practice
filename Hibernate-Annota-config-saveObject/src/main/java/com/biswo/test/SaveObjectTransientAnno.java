package com.biswo.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biswo.entity.Movie;
import com.biswo.utility.HibernateUtility;

public class SaveObjectTransientAnno {

	public static void main(String[] args) {

		// Get the Session object
		Session session = HibernateUtility.getSession();

		// Transaction enable
		Transaction transaction = null;
		// try with resource
		try (session) {
			// begin the transaction
			transaction = session.beginTransaction();
			// create the object
			Movie movie = new Movie();
			// Here set the Budget value but still that value is not participating in the persistence
			// operation because the budget field is annotated with Transient annotation in entity class
			movie.setMovieBujet(20000045.0);
			movie.setMovieHero("Thalapati");
			movie.setMovieId(124785);
			movie.setMovieName("Master");
			// save object
			session.save(movie);
			// commit the transaction
			transaction.commit();
			System.out.println("Object saved successsfully!!");
		} catch (Exception e) {
			if (transaction != null && transaction.getStatus() != null && transaction.getRollbackOnly()) {
				transaction.rollback();
				System.out.println("Object not saved");
			}
			e.printStackTrace();
		}

	}

}
