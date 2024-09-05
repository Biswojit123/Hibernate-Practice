package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Locker;

//We have requirement i want the earger loading then how to do that
//we have to approach to perform the earger loading
//we know we can't perform the lazy loading for final entity class but requirement is we perform the
//lazy operation then we have to use the interface that implemented by entity class

public class LoadObjectForEargerLoading {

	public static void main(String[] args) {
		// Bootstrapping hibernate
		Configuration config = new Configuration();

		// pass the xml configuration file to the configuration object
		config.configure("com/hibernate/config/hibernate.cfg.xml");

		// Build the Session factory object specify the xml configuration file
		SessionFactory factory = config.buildSessionFactory();

		// Get the session object from the session object basically it will use the
		// transfer the object persistence to hibernate framework
		Session session = factory.openSession();

		// Here we use the java 1.9 version concept
		try (factory; session) {
			// here we pass the id to the load method to perform the earger loading throw
			// this load method
			Locker locker = session.load(Locker.class, 1);// here poxyObject object is not returned because it direct
															// interact with data base
			System.out.println(locker.getClass());// it simple real object of entity class
			System.out.println(locker.getClass() + " Internal Class is:" + locker.getClass().getSuperclass());
			// in this case the real class super class is object class

			System.out.println(locker.getLockerId());// it print the locker id from the real object direct interact with
														// database
//			System.out.println(locker.getLockerName()+"----"+locker.getLockerPass()+"----"+locker.getPerson()+"----"+locker.getLockerId());
		} catch (HibernateException e) {
			System.out.println("Record not found");
			e.printStackTrace();
		}

	}

}
