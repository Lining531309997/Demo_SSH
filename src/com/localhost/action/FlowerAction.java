package com.localhost.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.localhost.service.ICatalogService;
import com.localhost.service.IFlowerService;
import com.localhost.util.Pager;
import com.localhost.vo.Catalog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("flowerAction")
@Scope("prototype")
public class FlowerAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Resource
	private ICatalogService catalogService;
	
	@Resource
	private IFlowerService  flowerService;
	
	private int catalogid;
	private int currentPage=1;
	

	public String browseCatalog() throws Exception{

		List<Catalog> catalogs = catalogService.getAllCatalogs();
		Map<String, Object> request = (Map) ActionContext.getContext().get("request");
		request.put("catalogs",catalogs);
		return SUCCESS;
	}
	
	public String browseNewFlower() throws Exception{

		List newflowers=flowerService.getNewFlower();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("newflowers",newflowers);
		return SUCCESS;
	}
	public String browseFlowerPaging()throws Exception
	{
	int totalSize=flowerService.getTotalByCatalog(catalogid);
	Pager page=new Pager(currentPage, totalSize);
	List flowers=flowerService.getFlowerByCatalogidPaging(catalogid, currentPage, page.getPageSize());
	Map request=(Map) ActionContext.getContext().get("request");
	request.put("flowers",flowers);
	request.put("page",page);
	return SUCCESS;	
	}
}
