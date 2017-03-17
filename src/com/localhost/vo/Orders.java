package com.localhost.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderid;					// 订单号
	private User user;							// 下订单的用户表
	private Timestamp orderdate;				// 订单时间
	private Set orderitems = new HashSet(0);	// 订单内容

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(User user, Timestamp orderdate, Set orderitems) {
		this.user = user;
		this.orderdate = orderdate;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}