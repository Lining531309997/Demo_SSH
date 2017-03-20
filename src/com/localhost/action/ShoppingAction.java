package com.localhost.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.localhost.service.FlowerService;
import com.localhost.tool.Cart;
import com.localhost.vo.Flower;
import com.localhost.vo.Orderitem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("shoppingAction")
@Scope("prototype")
public class ShoppingAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	// 鲜花的ID
	private int id;
	
	// 鲜花的购买数量
	private int quantity;
	
	@Resource
	private FlowerService flowerService;

	/**
	 * 添加需要购买的商品到购物车
	 * @return 
	 * @throws Exception
	 */
	public String addToCart() throws Exception {
		
		Flower flower = flowerService.getFlowerById(id);
		Orderitem orderitem = new Orderitem();
		orderitem.setFlower(flower);
		orderitem.setQuantity(quantity);
		
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		if(cart == null) {
			cart = new Cart();
		}
		cart.addFlower(id, orderitem);
		session.put("cart", cart);

		return SUCCESS;
	}
	
	/**
	 * 更新购物车
	 * @return
	 * @throws Exception
	 */
	public String updateCart() throws Exception {
		
		Map<String, Object> session = (Map<String, Object>)ActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		cart.updateCart(id, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
	
	/**
	 * 结算
	 * @return
	 * @throws Exception
	 */
	public String checkout() throws Exception {
		
		Map<String, Object> session = (Map<String, Object>)ActionContext.getContext().getSession();
		Cart cart = (Cart)session.get("cart");
		cart.updateCart(id, quantity);
		session.put("cart",cart);
		return SUCCESS;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
