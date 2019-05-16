package com.suchuner.crm.action;

import com.suchuner.crm.domain.LinkMan;
import com.suchuner.crm.service.ILinkManService;

public class LinkManAction extends BaseAction<LinkMan> {

	
	private ILinkManService linkManService;
	
	public void setLinkManService(ILinkManService linkManService) {
		this.linkManService = linkManService;
		super.setBaseService(linkManService);
	}
	
}
