package com.localhost.service.impl;


import com.localhost.dao.IOrderDAO;
import com.localhost.dao.impl.OrderDAO;
import com.localhost.service.IOrderService;
import com.localhost.vo.Orders;

public class OrderService implements IOrderService{
private IOrderDAO orderDAO;

	
	public IOrderDAO getOrderDAO() {
	return orderDAO;
}


public void setOrderDAO(IOrderDAO orderDAO) {
	this.orderDAO = orderDAO;
}


	@Override
	public Orders saveOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDAO.saveOrder(order);
	}

}
