package com.suchuner.crm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.suchuner.crm.domain.SaleVisit;
import com.suchuner.crm.domain.User;
import com.suchuner.crm.exception.CrmException;
import com.suchuner.crm.service.IUserService;
import com.suchuner.crm.utils.MD5Utils;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class UserAction extends BaseAction<User>{

	
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
		super.setBaseService(userService);
	}
	/**
	 * 实现用户的注册功能
	 * @return result页面
	 */
	public String regist(){
		try {
			userService.save(getT());
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	/**登录
	 * @return
	 */
	public String login(){
		try {
			User loginUser = userService.login(getT());
			ActionContext.getContext().getSession().put("loginUser", loginUser);
			return "login_success";
		} catch (CrmException e) {
			this.addActionError(e.getMessage());
			e.printStackTrace();
			return LOGIN;
		}
	}
	public String exit(){
			ActionContext.getContext().getSession().clear();
			return LOGIN;
	}
	public String pwdUI(){
		return "pwdUI";
	}
	private String oldPwd;
	
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String resetPwd(){
		User loginUser = (User) ActionContext.getContext().getSession().get("loginUser");
		String newPwd=getT().getUser_password();
		userService.resetPwd(loginUser,newPwd);
		ActionContext.getContext().getSession().clear();
		return "login";
	}
	/**
	 * 用于异步传输的方法
	 */
	public void  ajaxListAll(){
		List<User> list = userService.listAll();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{});
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
