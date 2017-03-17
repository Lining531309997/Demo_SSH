package com.localhost.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.localhost.dao.ICatalogDAO;
import com.localhost.service.ICatalogService;
import com.localhost.vo.Catalog;

@Service
public class CatalogService implements ICatalogService {
	
	@Resource
	private ICatalogDAO catalogDAO;

	@Override
	public List<Catalog> getAllCatalogs() {
		return catalogDAO.getAllCatalogs();
	}

}
