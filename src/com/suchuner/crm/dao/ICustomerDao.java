package com.suchuner.crm.dao;

import java.util.List;
import java.util.Map;

import com.suchuner.crm.domain.Customer;

public interface ICustomerDao extends IBaseDao<Customer>{

	/**dao层实现行业统计分析得查询
	 * @return 行业名称和数量的map集合
	 */
	public List<Map<String, Long>> totalIndustry();

	/**dao层实现来源统计分析得查询
	 * @return 来源名称和数量的map集合
	 */
	public List<Map<String, Long>> totalSource();


}
