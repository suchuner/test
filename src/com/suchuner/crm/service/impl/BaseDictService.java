package com.suchuner.crm.service.impl;

import java.util.List;

import com.suchuner.crm.dao.IBaseDictDao;
import com.suchuner.crm.domain.BaseDict;
import com.suchuner.crm.service.IBaseDictService;

public class BaseDictService extends BaseService<BaseDict> implements IBaseDictService {

	private IBaseDictDao baseDictDao;
	
	public void setBaseDictDao(IBaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
		super.setBaseDao(baseDictDao);
	}

	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return baseDictDao.findByTypeCode(dict_type_code);
	}

	
}
