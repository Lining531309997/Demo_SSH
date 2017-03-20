package com.localhost.service;

import java.util.List;

import com.localhost.vo.Flower;

public interface FlowerService {
		
	/**
	 * 获取新上架的鲜花
	 * @return 新上架的鲜花
	 */
	List<Flower> getNewFlower();
	
	/**
	 * 根据品种查看该品种鲜花数量
	 * @param catalogid 品种编号
	 * @return 该品种鲜花数量
	 */
	int getTotalByCatalog(int catalogid);
	
	/**
	 * 获取当前页显示的内容
	 * @param catalogid 鲜花品种
	 * @param currentPage 当前页
	 * @param pageSize 页面显示数量
	 * @return 当前页显示的内容
	 */
	List<Flower> getFlowerByCatalogidPaging(int catalogid, int currentPage, int pageSize);
	
	/**
	 * 根据ID获取鲜花
	 * @param id 鲜花的ID
	 * @return
	 */
	Flower getFlowerById(int id); 
}
