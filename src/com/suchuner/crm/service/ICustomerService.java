package com.suchuner.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.suchuner.crm.domain.Customer;

@Transactional
public interface ICustomerService extends IBaseService<Customer>{

	/**业务层实现行业统计分析得方法
	 * @return 行业名称和数量的map集合
	 */
	public List<Map<String, Long>> totalIndustry();

	/**业务层实现来源统计分析得方法
	 * @return 来源名称和数量的map集合
	 */
	public List<Map<String, Long>> totalSource();

}
