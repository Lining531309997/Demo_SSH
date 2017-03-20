package com.localhost.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.localhost.dao.UserDAO;
import com.localhost.service.UserService;
import com.localhost.vo.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDAO userDAO;
	
	@Override
	public boolean addOrUpdateUser(User user) {
		return userDAO.addOrUpdateUser(user);
	}
	
	@Override
	public User checkUser(User user) {
		return userDAO.checkUser(user);
	}
}
