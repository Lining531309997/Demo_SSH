package com.localhost.service;

import com.localhost.vo.Orders;


public interface OrderService {
	
	/**
	 * 保存订单
	 * @param order 订单
	 * @return
	 */
	boolean saveOrder(Orders order);
}
