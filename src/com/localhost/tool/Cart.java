package com.localhost.tool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.localhost.vo.Flower;
import com.localhost.vo.Orderitem;


public class Cart {
	
	private Map<Integer, Orderitem> items;
	
	public Map<Integer, Orderitem> getItems() {
		return items;
	}
	
	public void setItems(Map<Integer, Orderitem> items) {
		this.items = items;
	}
	
	/**
	 * 无参构造器
	 */
	public Cart() {
		if(items == null) {
			items = new HashMap<Integer,Orderitem>();
		}
	}
	
	/**
	 * 向购物车添加商品
	 * @param flowerId 鲜花的ID
	 * @param orderitem 订单项
	 */
	public void addFlower(int flowerId, Orderitem orderitem) {
		if(items.containsKey(flowerId)) {
			Orderitem _orderitem = (Orderitem)items.get(flowerId);
			orderitem.setQuantity(_orderitem.getQuantity() + orderitem.getQuantity());
			items.put(flowerId, orderitem);
		} else {
			items.put(flowerId, orderitem);
		}
	}
	
	/**
	 * 更新购物车
	 * @param flowerId 鲜花ID
	 * @param quantity 购买的鲜花数量
	 */
	public void updateCart(int flowerId, int quantity) {
		Orderitem orderitem = (Orderitem)items.get(flowerId);
		orderitem.setQuantity(quantity);
		items.put(flowerId, orderitem);
	}
	
	/**
	 * 获取购物车中商品总价
	 * @return 购物车中商品总价
	 */
	public int getTotalPrice() {
		int totalPrice = 0;
		for(Iterator<Orderitem> it = items.values().iterator(); it.hasNext(); ) {
			Orderitem orderitem = (Orderitem)it.next();
			Flower flower = orderitem.getFlower();
			int quantity = orderitem.getQuantity();
			totalPrice += flower.getPrice() * quantity;
		}
		return totalPrice;
	}
}
