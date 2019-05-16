package com.suchuner.crm.action.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.suchuner.crm.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if(loginUser==null){
		ActionSupport	action = (ActionSupport) invocation.getAction();
		action.addActionError("亲,你还未登录!");
		return "login";
		}else{
		return invocation.invoke();
		}
	}

}
