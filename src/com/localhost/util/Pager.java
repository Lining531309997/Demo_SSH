package com.localhost.util;

public class Pager {
	
	private int currentPage;		// 当前页的编号
	private int pageSize = 4;		// 每页显示数量
	private int totalSize;			// 数据记录的总数
	private int totalPage;			// 总页数
	private boolean hasFirst;		// 是否是首页
	private boolean hasPrevious;	// 是否有前一页
	private boolean hasNext;		// 是否有下一页
	private boolean hasLast;		// 是否是尾页
	
	/**
	 * 有参构造器
	 * @param currentPage 当前页的编号
	 * @param totalSize 数据记录的总数量
	 */
	public Pager(int currentPage, int totalSize){
		this.currentPage=currentPage;
		this.totalSize=totalSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalSize() {
		return totalSize;
	}
	
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	public int getTotalPage() {
		totalPage = totalSize/pageSize;
		if((totalSize % pageSize) != 0){
			totalPage++;
		}
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public boolean isHasFirst() {
		if(currentPage == 1){
			return false;
		}
		return true;
	}
	
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	
	public boolean isHasPrevious() {
		if(isHasFirst()){
			return true;
		} else {
			return false;
		}
	}
	
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public boolean isHasNext() {
		if(isHasLast())
			return true;
		else
			return false;
	}
	
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	public boolean isHasLast() {
		if(currentPage == getTotalPage()){
			return false;
		} else {
			return true;
		}
	}
	
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
}

