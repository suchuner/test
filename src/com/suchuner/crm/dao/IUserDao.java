package com.suchuner.crm.dao;

import com.suchuner.crm.domain.User;

public interface IUserDao  extends IBaseDao<User>{

	/**新建用户
	 * @param user
	 */
	public void save(User user);

	/**查询登录用户是否存在
	 * @param user
	 * @return
	 */
	public User login(User user);

}
