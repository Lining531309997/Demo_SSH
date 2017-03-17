package com.localhost.vo;

/**
 * Guashi entity. @author MyEclipse Persistence Tools
 */

public class Guashi implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;	// 挂失表编号
	private User user;	// 挂失用户

	// Constructors

	/** default constructor */
	public Guashi() {
	}

	/** full constructor */
	public Guashi(User user) {
		this.user = user;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}