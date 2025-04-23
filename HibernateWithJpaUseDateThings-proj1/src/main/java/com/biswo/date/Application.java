package com.biswo.date;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import com.biswo.date.dao.OrderImplemation;
import com.biswo.date.dao.OrderInterface;
import com.biswo.date.entity.Order;

public class Application {
	private static OrderInterface order;
	static {
		order = new OrderImplemation();
	}

	public static void main(String[] args) {
		//Create the Order Objects
		Order order1 = new Order();
		order1.setOrderName("Ear-Boat");
		order1.setPrice(20000.0);
		order1.setOrderDate(LocalDateTime.of(2002, 01, 24, 2, 20));
		
		Order order2 = new Order();
		order2.setOrderName("Laptop");
		order2.setPrice(25000.0);
		order2.setOrderDate(LocalDateTime.of(2002, Month.APRIL, 22, 5, 25));
		
		Order order3 = new Order();
		order3.setOrderName("Mobile");
		order3.setPrice(55000.0);
		order3.setOrderDate(LocalDateTime.of(2024, Month.DECEMBER,23,5,25));
		
		//Create the List
		List<Order> orders = List.of(order1,order2,order3);
		
		//call the method to save the object
		order.addOrders(orders);

	}

}
