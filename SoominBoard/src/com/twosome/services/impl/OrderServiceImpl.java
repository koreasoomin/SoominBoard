package com.twosome.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.twosome.common.Utils;
import com.twosome.dao.OrderDao;
import com.twosome.model.Order;
import com.twosome.services.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao ordersDao;

	@Autowired
	OrderServiceImpl(OrderDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public List<Order> list() {
		return ordersDao.list();
	}

	@Override
	public List<Order> getOrder(Order order) {
		return ordersDao.getOrder(order);
	}

	@Override
	public int newOrder(Order order) {
		return ordersDao.newOrder(order);
	}

	@Override
	public String newOrder(String jsonStr) {
		Order order = Order.makeByJsonStr(jsonStr);
		if (order.ret != null) { // 실패
			return order.ret;
		}
		int ret = newOrder(order);
		return Utils.makeJsonResult((ret == 1) ? true : false, order.getNum());
	}

	public int updateOrder(Order order) {
		return ordersDao.updateOrder(order);
	}

	@Override
	public String updateOrder(String jsonStr) {
		Order order = Order.makeByJsonStr(jsonStr);
		if (order.ret != null) { // 실패
			return order.ret;
		}
		int ret = updateOrder(order);
		return Utils.makeJsonResult((ret == 1) ? true : false, order.getNum());
	}

	public int deleteOrder(Order order) {
		return ordersDao.deleteOrder(order);
	}

	@Override
	public String deleteOrder(String jsonStr) {
		Order order = Order.makeByJsonStr(jsonStr);
		if (order.ret != null) { // 실패
			return order.ret;
		}
		int ret = deleteOrder(order);
		return Utils.makeJsonResult((ret == 1) ? true : false, order.getNum());
	}

	@Override
	public String reUpdate(String jsonStr) {
		Order order = Order.makeByJsonStr(jsonStr);
		if (order.ret != null) { // 실패
			return order.ret;
		}
		int ret = updateOrder(order);
		return Utils.makeJsonResult((ret == 1) ? true : false, order.getNum());
	}

	public int reUpdate(Order order) {
		return ordersDao.reUpdate(order);
	}

	@Override
	public String getUpdateNum(String jsonStr) {
		Order order = Order.makeByJsonStr(jsonStr);
		if (order.ret != null) { // 실패
			return order.ret;
		}
		int ret = getUpdateNum(order);
		return Utils.makeJsonResult((ret == 1) ? true : false, order.getNum());
	}

	public int getUpdateNum(Order order) {
		return ordersDao.getUpdateNum(order);
	}

	@Override
	public String reDelete(String jsonStr) {
		Order order = Order.makeByJsonStr(jsonStr);
		if (order.ret != null) { // 실패
			return order.ret;
		}
		int ret = reDelete(order);
		return Utils.makeJsonResult((ret == 1) ? true : false, order.getNum());
	}
	
	public int reDelete(Order order) {
		return ordersDao.reDelete(order);

	}


}
