package com.localhost.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.localhost.dao.OrderDAO;
import com.localhost.service.OrderService;
import com.localhost.vo.Orders;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Resource
	private OrderDAO orderDAO;
	
	@Override
	public boolean saveOrder(Orders order) {
		return orderDAO.saveOrder(order);
	}

}
