package com.suchuner.crm.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.suchuner.crm.dao.ICustomerDao;
import com.suchuner.crm.domain.Customer;

public class CustomerDao extends BaseDao<Customer> implements ICustomerDao{
	/**离线查询对象*/
		DetachedCriteria dc =null;
	
	public  DetachedCriteria getDetachedCritria(Customer customer){
		dc =DetachedCriteria.forClass(Customer.class);
		if(customer!=null){
			if(customer.getCust_name()!=null&&!customer.getCust_name().trim().equals("")){
				dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
			}
			if(customer.getBaseDictLevel()!=null&&customer.getBaseDictLevel().getDict_id()!=null&&!customer.getBaseDictLevel().getDict_id().trim().equals("")){
				dc.add(Restrictions.eq("baseDictLevel", customer.getBaseDictLevel()));
			}
			if(customer.getBaseDictSource()!=null&&customer.getBaseDictSource().getDict_id()!=null&&!customer.getBaseDictSource().getDict_id().trim().equals("")){
				dc.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
			}
	}
		return dc;
	}

	public List<Map<String, Long>> totalIndustry() {
		String hql = "SELECT new Map(b.dict_item_name as name,count(c.baseDictIndustry) as y) FROM Customer c,BaseDict b WHERE c.baseDictIndustry=b.dict_id GROUP BY b.dict_item_name";
		return (List<Map<String, Long>>) this.getHibernateTemplate().find(hql);
	}

	public List<Map<String, Long>> totalSource() {
		String hql="SELECT new Map(b.dict_item_name as name,count(c.baseDictSource) as y) FROM Customer c,BaseDict b WHERE c.baseDictSource=b.dict_id GROUP BY b.dict_item_name";
		return (List<Map<String, Long>>) this.getHibernateTemplate().find(hql);
	}
	
	

}
