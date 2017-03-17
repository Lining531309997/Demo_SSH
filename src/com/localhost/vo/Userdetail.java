package com.localhost.vo;

import java.util.Date;
/**
 * Userdetail entity. @author MyEclipse Persistence Tools
 */

public class Userdetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userid;		// 用户ID
	private User user;			// 与用户表通过userid一对一关联
	private Byte xb;			// 用户性别
	private String truename;	// 用户真实姓名
	private Date csrq;			// 用户出生日期
	private String phone;		// 用户电话
	private String email;		// 用户邮件
	private String address;		// 用户住址

	// Constructors

	/** default constructor */
	public Userdetail() {
	}

	/** minimal constructor */
	public Userdetail(User user) {
		this.user = user;
	}

	/** full constructor */
	public Userdetail(User user, Byte xb, String truename, Date csrq,
			String phone, String email, String address) {
		this.user = user;
		this.xb = xb;
		this.truename = truename;
		this.csrq = csrq;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Byte getXb() {
		return xb;
	}

	public void setXb(Byte xb) {
		this.xb = xb;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}