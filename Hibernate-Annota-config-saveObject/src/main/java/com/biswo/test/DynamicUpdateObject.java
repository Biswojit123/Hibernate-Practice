package com.biswo.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biswo.entity.Movie;
import com.biswo.utility.HibernateUtility;

public class DynamicUpdateObject {

	public static void main(String[] args) {
		// Get the session object
		Session session = HibernateUtility.getSession();
		// Create the transaction object
		Transaction transaction = null;
		// try with resources
		try (session) {
			// first the load the object from the
			Movie movie = session.get(Movie.class, 12534);
			if (movie == null) {
				System.out.println("Record is not present!!");
			} else {
				// Begin the transaction
				transaction = session.beginTransaction();
				// Create the Object
				movie.setMovieBujet(5635965.2);
				// update the object
				session.update(movie);
				// commit the transaction
				transaction.commit();
				System.out.println("Object Updated successfully!");
			}
		} catch (Exception e) {
			if (transaction != null && transaction.getStatus() != null && transaction.getRollbackOnly()) {
				transaction.rollback();
				System.out.println("Object not updated!!");
			}
			e.printStackTrace();
		}

	}

}
