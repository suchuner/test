package com.suchuner.crm.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.suchuner.crm.dao.ISaleVisitDao;
import com.suchuner.crm.domain.SaleVisit;

public class SaleVisitDao extends BaseDao<SaleVisit> implements ISaleVisitDao{
	

	protected DetachedCriteria getDetachedCritria(SaleVisit saleVisit) {
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		if(saleVisit!=null){
			if(saleVisit.getVisit_time()!=null){
				dc.add(Restrictions.ge("visit_time", saleVisit.getVisit_time()));
			}
			if(saleVisit.getVisit_end_time()!=null){
				dc.add(Restrictions.le("visit_time", saleVisit.getVisit_end_time()));
			}
		}
		return dc;
	}


	
}
