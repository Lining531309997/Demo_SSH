package com.localhost.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.localhost.dao.IFlowerDAO;
import com.localhost.service.IFlowerService;
import com.localhost.vo.Flower;

@Service("flowerService")
public class FlowerService implements IFlowerService {
	
	@Resource(name="flowerDAO")
	private IFlowerDAO flowerDAO;
	
	/*
	public IFlowerDAO getFlowerDAO() {
		return flowerDAO;
	}


	public void setFlowerDAO(IFlowerDAO flowerDAO) {
		this.flowerDAO = flowerDAO;
	}*/


	public List getNewFlower() {
		// TODO Auto-generated method stub
		return flowerDAO.getNewFlower();
	}

	public List getFlowerByCatalogidPaging(int catalogid, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return flowerDAO.getFlowerByCatalogidPaging(catalogid, currentPage, pageSize);
	}
	public int getTotalByCatalog(int catalogid){
		
		return flowerDAO.getTotalByCatalog(catalogid);
	}
	public Flower getFlowerById(int id) {
		// TODO Auto-generated method stub
		return flowerDAO.getFlowerById(id);
	}
}
