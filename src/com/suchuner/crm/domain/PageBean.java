package com.suchuner.crm.domain;

import java.util.List;

public class PageBean<T> {
	private Integer currPage;//当前页
	private Integer pageSize;//每页显示的记录数
	private Integer totalCount;//该次查询的总记录数
	private Integer totalPage;//该次查询的总的页数
	private List<T> list;//查询到的需要被展示的数据
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalCount,Integer pageSize) {
		Double totalCount1=totalCount.doubleValue();
		Double pageSize1=pageSize.doubleValue();
		this.totalPage = (int) Math.ceil((totalCount1/pageSize1));
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
