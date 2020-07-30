package com.twosome.services;

import java.util.List;

import com.twosome.model.Order;

public interface OrderService {

	public List<Order> list();
	
	int newOrder(Order order);		// C
	String newOrder(String jsonStr);	// C
	String updateOrder(String jsonStr);		// U
	String deleteOrder(String jsonStr);		// D
	
	List<Order> getOrder(Order order);	// R 


	String reUpdate(String jsonStr);

	String getUpdateNum(String jsonStr);

	String reDelete(String jsonStr);
}
