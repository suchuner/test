package com.suchuner.crm.service.impl;

import java.util.List;

import com.suchuner.crm.dao.IBaseDao;
import com.suchuner.crm.domain.PageBean;
import com.suchuner.crm.exception.CrmException;
import com.suchuner.crm.service.IBaseService;

public class BaseService<T> implements IBaseService<T> {

	private IBaseDao<T> baseDao;
	
	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public void save(T t) {
		baseDao.save(t);
	}
	/**业务层实现客户查询的分页显示
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean findAll(T t,Integer currPage, Integer pageSize) {
		/*需求:需要将返回的pageBean封装好,所以pageBean中需要什么数据,在业务层就将什么数据封装进去
		 * 实现步骤:
		 * 1.currPage数据,pageSize,totalCount,totalPage,list
		 * 2.totalCount,list需要从数据库中查询
		 * 3.totalPage需要用得到的数据注入
		 * 
		 * */
		PageBean<T> pb= new PageBean<>();
		Integer begin =(currPage-1)*pageSize;//dao层的查询需要的是索引,即从第几条开始查询
		Integer totalCount =baseDao.getCount(t).intValue();
		pb.setCurrPage(currPage);
		pb.setPageSize(pageSize);
		pb.setTotalCount(totalCount);
		pb.setTotalPage(totalCount, pageSize);
		if(pb.getTotalPage()>0&&currPage>pb.getTotalPage()){
			throw new CrmException("输入的页码不存在,请重新输入");
		}
		List<T> list = baseDao.findAll(t,begin,pageSize);
		pb.setList(list);
		return pb;
	}

	public void delete(T t) {
			baseDao.delete(t);
	}

	public T findById(Long cust_id) {
		return baseDao.findById(cust_id); 
	}

	public void update(T t) {
		baseDao.update(t);
	}

	public List<T> listAll() {
		return baseDao.listAll();
	}
}
