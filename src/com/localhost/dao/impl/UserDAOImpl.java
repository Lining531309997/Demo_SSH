package com.localhost.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.localhost.dao.UserDAO;
import com.localhost.vo.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public boolean addOrUpdateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();
		session.close();
		return true;
	}
	
	@Override
	public User checkUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<User> query = session.createQuery("from User where username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "' and role = '" + user.getRole() + "'");
	    User loginUser = new User();
		List<User> list = query.list();
		transaction.commit();
		session.close();
        if(list.size() != 0) {
        	loginUser = (User)list.get(0);
        	return loginUser;
		}
        return null;
	}


}
