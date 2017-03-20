package com.localhost.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.localhost.dao.FlowerDAO;
import com.localhost.service.FlowerService;
import com.localhost.vo.Flower;

@Service("flowerService")
public class FlowerServiceImpl implements FlowerService {
	
	@Resource(name="flowerDAO")
	private FlowerDAO flowerDAO;
	
	@Override
	public List<Flower> getNewFlower() {
		return flowerDAO.getNewFlower();
	}

	@Override
	public List<Flower> getFlowerByCatalogidPaging(int catalogid, int currentPage, int pageSize) {
		return flowerDAO.getFlowerByCatalogidPaging(catalogid, currentPage, pageSize);
	}
	
	@Override
	public int getTotalByCatalog(int catalogid) {
		return flowerDAO.getTotalByCatalog(catalogid);
	}
	
	@Override
	public Flower getFlowerById(int id) {
		return flowerDAO.getFlowerById(id);
	}
}
