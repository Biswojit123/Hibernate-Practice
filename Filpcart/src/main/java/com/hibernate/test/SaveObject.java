package com.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Order;

public class SaveObject {

	public static void main(String[] args) {
		//Bootstrap or hibernate Activate
		Configuration config = new Configuration();
		
		//Specify the hibernate configuration file 
		config.configure("com/hibernate/config/hibernate.cfg.xml");
		
		//Build the session factory object that specify the all property and resources
		SessionFactory factory = config.buildSessionFactory();
		
		//Create the session object for bridge between the hibernate frame work and java application
		Session session = factory.openSession();
		
		//Create the Transaction object for accuracy maintain in data base
		Transaction tax = null;
		
		try {
			//it internally call the con.setAutocommit(false) so it disable the auto commit in database
			tax = session.beginTransaction();
			
			//Create the Object
			Order order = new Order();
			//order.setAmount(23000.0);
			order.setOrderId(1256354);
			order.setOrderType("UPI-Payment");
			//order.setQty("5");
	
			//Save the object
			Integer orderId = (Integer) session.save(order);
			
			//Return generated order id
			System.out.println("Genereted Order Id ::"+orderId);
			
			//set the auto commit
			tax.commit();
			
			//print the object
			System.out.println("Object inserted successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			tax.rollback();
			System.out.println("Object is not saved(Record is not inserted)");
		}finally {
			//close the all resources
			session.close();
			factory.close();
		}//end final

	}//end main

}//end class
