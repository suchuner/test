package com.suchuner.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suchuner.crm.domain.PageBean;
@Transactional
public interface IBaseService<T> {

	public void save(T t);

	/**
	 * @param t 高级查询所封装好的条件对象
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public PageBean findAll(T t, Integer currPage, Integer pageSize);

	public void delete(T t);

	/**根据对象的id查询该对象
	 * @param cust_id 对象的id
	 * @return 该对象
	 */
	public T findById(Long cust_id);

	/** 客户的修改功能
	 * @param t
	 */
	public void update(T t);

	/**
	 * @return返回所有的对象
	 */
	public List<T> listAll();
}
