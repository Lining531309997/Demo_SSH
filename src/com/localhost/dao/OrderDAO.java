package com.localhost.dao;

import com.localhost.vo.Orders;

public interface OrderDAO {
	
	/**
	 * 保存订单
	 * @param order 订单
	 * @return
	 */
	boolean saveOrder(Orders order);
}
