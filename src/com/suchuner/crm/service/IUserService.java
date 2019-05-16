package com.suchuner.crm.service;

import org.springframework.transaction.annotation.Transactional;

import com.suchuner.crm.domain.User;

@Transactional
public interface IUserService extends IBaseService<User>{

	/**
	 * @param user 添加用户
	 */
	public void save(User user);

	/**用户登录
	 * @param user 存有用户的账号和密码的对象
	 * @return 该对象的信息
	 */
	public User login(User user);

	/**修改密码
	 * @param loginUser
	 * @param newPwd 
	 */
	public void resetPwd(User loginUser, String newPwd);

}
