package com.suchuner.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suchuner.crm.domain.BaseDict;

@Transactional
public interface IBaseDictService extends IBaseService<BaseDict>{

	public List<BaseDict> findByTypeCode(String dict_type_code);

}
