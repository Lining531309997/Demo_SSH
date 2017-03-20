package com.localhost.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.localhost.service.CatalogService;
import com.localhost.service.FlowerService;
import com.localhost.util.Pager;
import com.localhost.vo.Catalog;
import com.localhost.vo.Flower;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("flowerAction")
@Scope("prototype")
public class FlowerAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Resource
	private CatalogService catalogService;
	
	@Resource
	private FlowerService flowerService;
	
	// 鲜花品种编号
	private int catalogid;
	
	// 默认当前页为首页
	private int currentPage = 1;
	
	/**
	 * 获取鲜花品种
	 * @return 
	 * @throws Exception
	 */
	public String browseCatalog() throws Exception {
		// 获取鲜花所有品种
		List<Catalog> catalogs = catalogService.getAllCatalogs();
		// 封装数据
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("catalogs",catalogs);
		return SUCCESS;
	}
	
	/**
	 * 获取新上架的部分鲜花
	 * @return 新上架的鲜花
	 * @throws Exception
	 */
	public String browseNewFlower() throws Exception{
		// 获取新上架的鲜花
		List<Flower> newflowers = flowerService.getNewFlower();
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("newflowers",newflowers);
		return SUCCESS;
	}
	
	/**
	 * 打开浏览鲜花页面
	 * @return 
	 * @throws Exception
	 */
	public String browseFlowerPaging() throws Exception {
		System.out.println(catalogid);
		// 某品种鲜花的总数
		int totalSize = flowerService.getTotalByCatalog(catalogid);
		// 分页处理
		Pager page = new Pager(currentPage, totalSize);
		// 当前页需要显示的鲜花
		List<Flower> flowers = flowerService.getFlowerByCatalogidPaging(catalogid, currentPage, page.getPageSize());
		// 封装数据
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("flowers",flowers);
		request.put("page",page);
		return SUCCESS;	
	}

	/**
	 * @return the catalogid
	 */
	public int getCatalogid() {
		return catalogid;
	}

	/**
	 * @param catalogid the catalogid to set
	 */
	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}
	
}
