package com.twosome.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.twosome.dao.OrderDao;
import com.twosome.model.Order;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

	private SqlSession sqlSession;

	static String namespace = "com.twosome";

	@Autowired
	OrderDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	// 게시물 목록 불러오기
//	@Override
//	public List<Order> list() {
//		return sqlSession.selectList(namespace + "list");
//	}
	@Override
	public List<Order> list() {
		return sqlSession.selectList("list");
	}

	// create
	@Override
	public int newOrder(Order order) {
		return sqlSession.insert("newOrder", order);
	}

	// read
	@Override
	public Order readOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	// update
	@Override
	public int updateOrder(Order order) {
		return sqlSession.update("updateOrder", order);
	}

	// delete
	@Override
	public int deleteOrder(Order order) {
		return sqlSession.delete("deleteOrder", order);
	}

	//
	@Override
	public List<Order> getOrder(Order order) {
		return sqlSession.selectList("getOrder", order);
	}

	@Override
	public int reUpdate(Order order) {
		return sqlSession.update("reUpdate", order);
	}

	@Override
	public int getUpdateNum(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reDelete(Order order) {
		return sqlSession.delete("reDelete", order);
	}

	
}
