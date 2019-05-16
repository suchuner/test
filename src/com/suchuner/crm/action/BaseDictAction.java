package com.suchuner.crm.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.suchuner.crm.domain.BaseDict;
import com.suchuner.crm.service.IBaseDictService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict>{

	private BaseDict baseDict = new BaseDict();
	public BaseDict getModel() {
		return baseDict;
	}
	private IBaseDictService baseDictService;
	
	public void setBaseDictService(IBaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	 public String findByTypeCode(){
		 List<BaseDict> list=baseDictService.findByTypeCode(baseDict.getDict_type_code());
		JsonConfig jsonConfig = new JsonConfig();
		//取出不需要的一些对象属性
		jsonConfig.setExcludes(new String[]{"dict_type_code","dict_item_code","dict_enable","dict_memo","dict_sort"});
		 JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		 try {
			//需要用response将返回数据传给页面
			 HttpServletResponse response = ServletActionContext.getResponse();
			 response.setContentType("text/html;charset=utf-8");
			 response.getWriter().println(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return null;
	 }
}
