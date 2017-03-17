package com.localhost.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Flower entity. @author MyEclipse Persistence Tools
 */

public class Flower implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer flowerid;					// 鲜花的编号
	private Catalog catalog;					// 鲜花分类
	private String flowername;					// 鲜花名称
	private Integer price;						// 鲜花价格
	private String picture;						// 鲜花图片
	private Set orderitems = new HashSet(0);	// 与订单项通过flowerid一对多关联

	// Constructors

	/** default constructor */
	public Flower() {
	}

	/** full constructor */
	public Flower(Catalog catalog, String flowername, Integer price,
			String picture, Set orderitems) {
		this.catalog = catalog;
		this.flowername = flowername;
		this.price = price;
		this.picture = picture;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getFlowerid() {
		return this.flowerid;
	}

	public void setFlowerid(Integer flowerid) {
		this.flowerid = flowerid;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public String getFlowername() {
		return this.flowername;
	}

	public void setFlowername(String flowername) {
		this.flowername = flowername;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}