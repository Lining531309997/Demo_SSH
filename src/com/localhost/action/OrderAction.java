package com.localhost.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.localhost.service.OrderService;
import com.localhost.tool.Cart;
import com.localhost.vo.Orderitem;
import com.localhost.vo.Orders;
import com.localhost.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private OrderService orderService;

	/**
	 * 购物结算
	 * @return
	 * @throws Exception
	 */
	public String checkOut() throws Exception {
		
		Map<String, Object> session = (Map<String, Object>)ActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		User user = (User)session.get("user");
		
		if(user == null) {
			return ERROR;		
		}
		
		Orders order = new Orders();
		order.setOrderdate(new Timestamp(new Date().getTime()));
		order.setUser(user);
		for(Iterator<Orderitem> iterator = cart.getItems().values().iterator(); iterator.hasNext(); ) {
			Orderitem orderitem = (Orderitem)iterator.next();
			order.getOrderitems().add(orderitem);
			orderitem.setOrders(order);
		}
		
		orderService.saveOrder(order);
		Map<String, Object> request = (Map<String, Object>)ActionContext.getContext().get("request");
		request.put("order", order);
		session.remove("cart");
		return SUCCESS;
	}
}
