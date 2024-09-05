package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Order;

public class PersitsObject {

	public static void main(String[] args) {
		
		//BootStraping the Hibernate Framework
		Configuration config = new Configuration();
		
		//Now add the configuration file to the Configuration object
		config.configure("com/hibernate/config/hibernate.cfg.xml");
		
		//so we have to check the actually configure or not
		//System.out.println(config.getProperties());
		
		//Create the SessionFactory object that having Specified services and the all other object
		SessionFactory factory = config.buildSessionFactory();
		
		//get the session object
		Session session = factory.openSession();
		
		//Create the Transaction Object
		Transaction transaction = null;
		
		try(factory;session) {
			//disable the auto commit in the database level
			transaction = session.beginTransaction();
			
			//Create the object
			Order order = new Order();
			order.setAmount(55000.00);
			//order.setOrderId(123456);
			order.setOrderType("UPI Payment");
			order.setQty("1");
			
			//Save the object throw the persist
			session.persist(order);
			
			//commit the transaction
			transaction.commit();
			
			System.out.println("Object saved successfully");
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(transaction!= null && transaction.getStatus()!= null) {
				transaction.rollback();
				System.out.println("Object is not saved");
			}
		}

	}

}
