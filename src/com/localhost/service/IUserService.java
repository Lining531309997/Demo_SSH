package com.localhost.service;

import java.util.List;

import com.localhost.vo.User;



public interface IUserService {
	
	
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
}
