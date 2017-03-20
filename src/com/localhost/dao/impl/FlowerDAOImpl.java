
package com.localhost.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.localhost.dao.FlowerDAO;
import com.localhost.vo.Flower;

@Repository("flowerDAO")
public class FlowerDAOImpl implements FlowerDAO {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Flower> getNewFlower() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Flower> query = session.createQuery("from Flower order by flowerid desc");
		// 只获取前五种新上架的鲜花（0-4）
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<Flower> flowers = query.list();
		transaction.commit();
		session.close();
		return flowers;
	}
	
	@Override
	public List<Flower> getFlowerByCatalogidPaging(int catalogid, int currentPage, int pageSize) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Flower> query = session.createQuery("from Flower where catalogid=" + catalogid);
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(startRow + pageSize - 1); 
		List<Flower> flowers = query.list();
		transaction.commit();
		session.close();
		return flowers;
	}
	
	@Override
	public int getTotalByCatalog(int catalogid) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Flower> query = session.createQuery("from Flower where catalogid=" + catalogid);
		List<Flower> flowers = query.list();
		transaction.commit();
		session.close();
		return flowers.size();
	}
	
	@Override
	public Flower getFlowerById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Flower> query = session.createQuery("from Flower where flowerid = " + id);
		List<Flower> flowers = query.list();
		transaction.commit();
		session.close();
		return (Flower) flowers.get(0);
	}
}
