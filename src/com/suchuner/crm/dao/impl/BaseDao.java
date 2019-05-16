package com.suchuner.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.suchuner.crm.dao.IBaseDao;

public abstract class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {
	private Class entityClass;
	public BaseDao(){
			Class  clazz = this.getClass();
			Type type = clazz.getGenericSuperclass();
			ParameterizedType  ptype = (ParameterizedType) type;
			Type[] types = ptype.getActualTypeArguments();
			this.entityClass=(Class) types[0];
	}
	
	protected abstract DetachedCriteria getDetachedCritria(T t);
	
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}
	
	public List<T> findAll(T t,Integer begin, Integer pageSize) {
		DetachedCriteria dc = getDetachedCritria(t);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc, begin, pageSize);
	}
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}
	public Long getCount(T t) {
		DetachedCriteria dc = getDetachedCritria(t);
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		return list.size()>0 ? list.get(0) : null;
	}

	public List<T> listAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+entityClass.getSimpleName());
	}

	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

}
