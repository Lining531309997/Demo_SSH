package com.localhost.vo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userid;						// 用户ID
	private String username;					// 用户名	
	private String password;					// 用户密码
	private String role;						// 角色：管理员or普通用户
	private Guashi guashi;						// 与挂失表通过userid一对一关联
	private Userdetail userdetail;				// 与用户详情通过userid一对一关联
	private Set orderses = new HashSet(0);		// 与订单表通过userid一对多关联

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, String role, Guashi guashi,
			Userdetail userdetail, Set orderses) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.guashi = guashi;
		this.userdetail = userdetail;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public Guashi getGuashi() {
		return guashi;
	}

	public void setGuashi(Guashi guashi) {
		this.guashi = guashi;
	}

	public Userdetail getUserdetail() {
		return this.userdetail;
	}

	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", role=" + role + ", guashi="
				+ guashi + ", userdetail=" + userdetail + ", orderses="
				+ orderses + "]";
	}

	
}