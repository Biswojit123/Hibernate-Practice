package com.swiggy.test;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.swiggy.entity.Menu;

public class SaveObject1 {

	public static void main(String[] args) {
		
		//Bootstrap or active the hibernate
		Configuration config = new Configuration();
		
		//Set the Configure file
		config.configure("com/swiggy/config/hibernate.cfg.xml");
		
		//Build the Session factory object to specify the configuration file resources
		SessionFactory factory = config.buildSessionFactory();
		
		//Create the Session Object 
		Session session = factory.openSession();
		
		//Create the Transaction Object
		Transaction tax = null;
		
		try {
			//set the auto commit false
			tax = session.beginTransaction();
			
			//Create the object for Menu
			Menu menu = new Menu();
			
			//Create the Map object
			Map<String,Double> mapData = new HashMap<>();
			mapData.put("Chiken", 200.0);
			mapData.put("Mutton", 500.0);
			mapData.put("Butter-Chiken", 250.0);
			
			//set the map MapData to Menu
			menu.setMenuData(mapData);
			menu.setMenuType("Non-veg");
			menu.setSerialNum(1);
			
			//save Object
			Integer serialNum = (Integer) session.save(menu);
			System.out.println("The insertedId is::"+serialNum);
			
			//set the Auto commit
			tax.commit();
			System.out.println("Object Inserted Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			tax.rollback();
			System.out.println("Object is not inserted due to server error");
		}finally {
			//Close the resources
			session.close();
			factory.close();
		}

	}//end main

}//end class
