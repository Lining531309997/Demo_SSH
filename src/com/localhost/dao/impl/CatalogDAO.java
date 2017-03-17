package com.localhost.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.localhost.dao.ICatalogDAO;
import com.localhost.vo.Catalog;

@Repository
public class CatalogDAO implements ICatalogDAO  {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Catalog> getAllCatalogs() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// HQL查询
		List<Catalog> catalogs = session.createQuery("from Catalog").list();
		transaction.commit();
		session.close();
		return catalogs;
	}


	

}
