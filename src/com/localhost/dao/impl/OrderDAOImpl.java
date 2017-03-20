package com.localhost.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.localhost.dao.OrderDAO;
import com.localhost.vo.Orders;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Resource
	private SessionFactory sessionFacory;

	@Override
	public boolean saveOrder(Orders order) {
		Session session = sessionFacory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(order);
		transaction.commit();
		session.close();
		return true;
	}
		
}
