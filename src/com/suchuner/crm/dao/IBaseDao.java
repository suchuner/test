package com.suchuner.crm.dao;

import java.io.Serializable;
import java.util.List;


public interface IBaseDao<T> {

	/**新增,保存该对象
	 * @param t
	 */
	public void save(T t);

	/**查询数库中的总记录数
	 * @return
	 */
	public Long getCount(T t);

	/**分页查询
	 * @param t 封装好的条件对象
	 * @param begin  分页查询中需要的起始记录	
	 * @param pageSize 每页的记录数
	 * @return 分好页的数据
	 */
	public List<T> findAll(T t, Integer begin, Integer pageSize);

	public void delete(T t);

	/**持久层用对象id查询对象
	 * @param cust_id 对象id
	 * @return 该对象
	 */
	public T findById(Serializable id);

	/**持久层实现客户的更新
	 * @param t
	 */
	public void update(T t);

	public List<T> listAll();
}
