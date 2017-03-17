package com.localhost.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Catalog entity. @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer catalogid;				// 分类编号
	private String catalogname;				// 分类名称
	private Set flowers = new HashSet(0);	// 与鲜花表通过catalogid一对多关联

	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** full constructor */
	public Catalog(String catalogname, Set flowers) {
		this.catalogname = catalogname;
		this.flowers = flowers;
	}

	// Property accessors

	public Integer getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public String getCatalogname() {
		return this.catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public Set getFlowers() {
		return this.flowers;
	}

	public void setFlowers(Set flowers) {
		this.flowers = flowers;
	}

}