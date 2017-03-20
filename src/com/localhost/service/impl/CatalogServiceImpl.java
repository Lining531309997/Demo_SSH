package com.localhost.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.localhost.dao.CatalogDAO;
import com.localhost.service.CatalogService;
import com.localhost.vo.Catalog;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {
	
	@Resource
	private CatalogDAO catalogDAO;

	@Override
	public List<Catalog> getAllCatalogs() {
		return catalogDAO.getAllCatalogs();
	}

}
