package com.localhost.dao;

import java.util.List;

import com.localhost.vo.Catalog;

public interface CatalogDAO {
	
	/**
	 * 获取鲜花所有品种
	 * @return 鲜花所有品种
	 */
	List<Catalog> getAllCatalogs();

}
