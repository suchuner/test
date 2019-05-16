package com.suchuner.crm.service.impl;

import java.util.List;
import java.util.Map;

import com.suchuner.crm.dao.ICustomerDao;
import com.suchuner.crm.domain.Customer;
import com.suchuner.crm.exception.CrmException;
import com.suchuner.crm.service.ICustomerService;

public class CustomerService extends BaseService<Customer> implements ICustomerService {
	private ICustomerDao customerDao;

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
		super.setBaseDao(customerDao);
	}
	public void save(Customer customer) {
		if(customer.getCust_name().trim().equals("")){
			throw new CrmException("客户名称不能为空");
		}
		customerDao.save(customer);
	}
	public List<Map<String, Long>> totalIndustry() {
		return customerDao.totalIndustry();
	}
	public List<Map<String, Long>> totalSource() {
		return customerDao.totalSource();
	}
}
