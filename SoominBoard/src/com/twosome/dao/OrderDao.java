package com.twosome.dao;
//DAO : Data Access Object

import java.util.List;
import javax.annotation.Resource;

import com.twosome.model.Order;

@Resource
public interface OrderDao {
	public List<Order> list();
	int newOrder(Order order);		// C
	Order readOrder(Order order);	// R 
	int updateOrder(Order order);		// U
	int deleteOrder(Order order);		// D
	List<Order> getOrder(Order order);
	int reUpdate(Order order);
	int getUpdateNum(Order order);
	int reDelete(Order order);
		
}

