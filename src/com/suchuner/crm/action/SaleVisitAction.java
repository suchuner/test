package com.suchuner.crm.action;

import com.suchuner.crm.domain.SaleVisit;
import com.suchuner.crm.service.ISaleVisitService;

public class SaleVisitAction extends BaseAction<SaleVisit>{

	
	private ISaleVisitService saleVisitService;
	
	public void setSaleVisitService(ISaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
		super.setBaseService(saleVisitService);
	}
	
}
