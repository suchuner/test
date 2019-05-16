package com.suchuner.crm.service.impl;

import com.suchuner.crm.dao.IUserDao;
import com.suchuner.crm.domain.User;
import com.suchuner.crm.exception.CrmException;
import com.suchuner.crm.service.IUserService;
import com.suchuner.crm.utils.MD5Utils;

public class UserService extends BaseService<User> implements IUserService {

	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
		super.setBaseDao(userDao);
	}

	public void save(User user) {
		user.setUser_state(User.USER_NORMAL);
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		userDao.save(user);
	}

	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		User loginUser = userDao.login(user);
		if(loginUser==null){
			throw new CrmException("用户名或密码不正确!");
		}
		return loginUser;
	}


	public void resetPwd(User loginUser, String newPwd) {
		User user = userDao.findById(loginUser.getUser_id());
		String newpwd = MD5Utils.md5(newPwd);
		user.setUser_password(newpwd);				
	}

}
