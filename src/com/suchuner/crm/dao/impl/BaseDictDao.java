package com.suchuner.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.suchuner.crm.dao.IBaseDictDao;
import com.suchuner.crm.domain.BaseDict;

public class BaseDictDao extends BaseDao<BaseDict> implements IBaseDictDao{
		protected DetachedCriteria getDetachedCritria(BaseDict t) {
			return null;
		}
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		String hql="from BaseDict where dict_type_code =?";
		return (List<BaseDict>) this.getHibernateTemplate().find(hql, dict_type_code);
	}

	


}
