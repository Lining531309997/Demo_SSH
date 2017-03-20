package com.localhost.service;

import com.localhost.vo.User;



public interface UserService {
	
	/**
	 * 新增或修改用户信息
	 * @param user 用户信息
	 * @return true :新增/修改成功
	 * 		   false:新增/修改失败
	 */
	boolean addOrUpdateUser(User user);
	
	/**
	 * 检查登陆用户是否存在
	 * @param user 登录用户
	 * @return 用户的所有信息
	 */
	User checkUser(User user);
}
