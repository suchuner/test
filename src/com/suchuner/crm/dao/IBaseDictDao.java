package com.suchuner.crm.dao;

import java.util.List;

import com.suchuner.crm.domain.BaseDict;

public interface IBaseDictDao  extends IBaseDao<BaseDict>{
	
	/**根据类型代码查询对象集合
	 * @param dict_type_code
	 * @return
	 */
	public List<BaseDict> findByTypeCode(String dict_type_code);

}
