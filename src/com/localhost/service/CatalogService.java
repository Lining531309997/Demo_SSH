package com.localhost.service;

import java.util.List;

import com.localhost.vo.Catalog;

public interface CatalogService {
	
	/**
	 * 获取鲜花所有品种
	 * @return 鲜花所有品种
	 */
	List<Catalog> getAllCatalogs();

}
