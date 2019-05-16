package com.suchuner.crm.service.impl;

import com.suchuner.crm.dao.ILinkManDao;
import com.suchuner.crm.domain.LinkMan;
import com.suchuner.crm.exception.CrmException;
import com.suchuner.crm.service.ILinkManService;

public class LinkManService extends BaseService<LinkMan> implements ILinkManService {

	private ILinkManDao linkManDao;
	
	public void setLinkManDao(ILinkManDao linkManDao) {
		this.linkManDao = linkManDao;
		super.setBaseDao(linkManDao);
	}

	public void save(LinkMan linkMan) {
		if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
			linkManDao.save(linkMan);
		}else{
		throw new CrmException("所属客户还未选择");
		}
	}

}
