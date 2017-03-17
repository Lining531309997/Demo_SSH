package com.localhost.service;

import java.util.List;

import com.localhost.vo.Flower;

public interface IFlowerService {
		public List getNewFlower();
		public List getFlowerByCatalogidPaging(int catalogid,int currentPage,int pageSize);
		public int getTotalByCatalog(int catalogid);
		public Flower getFlowerById(int id); 
}