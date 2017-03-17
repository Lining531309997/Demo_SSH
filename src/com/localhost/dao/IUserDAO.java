package com.localhost.dao;

import java.util.List;

import com.localhost.vo.User;

public interface IUserDAO {

	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
}
