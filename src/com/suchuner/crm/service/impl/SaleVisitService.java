package com.suchuner.crm.service.impl;

import com.suchuner.crm.dao.ISaleVisitDao;
import com.suchuner.crm.domain.SaleVisit;
import com.suchuner.crm.service.ISaleVisitService;

public class SaleVisitService extends BaseService<SaleVisit> implements ISaleVisitService {

	private ISaleVisitDao saleVisitDao;
	
	public void setSaleVisitDao(ISaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
		super.setBaseDao(saleVisitDao);
	}

}
