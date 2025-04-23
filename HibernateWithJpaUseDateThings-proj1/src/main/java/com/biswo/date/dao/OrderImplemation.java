package com.biswo.date.dao;

import java.util.List;

import com.biswo.date.entity.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OrderImplemation implements OrderInterface{

	@Override
	public void addOrders(List<Order> orders) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("date-config");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tra = manager.getTransaction();
		
		try(manager) {
			tra.begin();
			//take the one one object and persist
			for(Order order:orders) {
				manager.persist(order);
			}
			//commit the transaction
			System.out.println("Oders are saved.....");
			tra.commit();
		}catch(Exception e) {
			System.err.println("Some internal problem is occure...");
			tra.rollback();
			e.printStackTrace();
		}
		
	}

}
