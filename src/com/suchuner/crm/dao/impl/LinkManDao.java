package com.suchuner.crm.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.suchuner.crm.dao.ILinkManDao;
import com.suchuner.crm.domain.LinkMan;

public class LinkManDao extends BaseDao<LinkMan> implements ILinkManDao{
	DetachedCriteria dc =null;
	public  DetachedCriteria getDetachedCritria(LinkMan linkMan){
		dc =DetachedCriteria.forClass(LinkMan.class);
		if(linkMan!=null){
			if(linkMan.getLkm_name()!=null&&!linkMan.getLkm_name().trim().equals("")){
				dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
			}
			if(linkMan.getLkm_gender()!=null&&!linkMan.getLkm_gender().trim().equals("")){
				dc.add(Restrictions.eq("lkm_gender", linkMan.getLkm_gender()));
			}
	}
		return dc;
	}
}
