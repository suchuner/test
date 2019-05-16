package com.suchuner.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.suchuner.crm.dao.IUserDao;
import com.suchuner.crm.domain.User;

public class UserDao extends BaseDao<User> implements IUserDao{
	
	protected DetachedCriteria getDetachedCritria(User t) {
		return null;
	}

	public User login(User user) {
		String hql="from User where user_code = ? and user_password = ? ";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUser_code(),user.getUser_password());
		if(list.size()>0){
			return (User) list.get(0);
		}
		return null;
	}

	
}
