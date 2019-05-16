package com.suchuner.crm.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.suchuner.crm.domain.LinkMan;
import com.suchuner.crm.domain.PageBean;
import com.suchuner.crm.exception.CrmException;
import com.suchuner.crm.service.IBaseService;

public class BaseAction<T> extends ActionSupport{

	private T t ;
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	private  Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private IBaseService<T>  baseService;
	
	public void setBaseService(IBaseService<T> baseService) {
		this.baseService = baseService;
	}
	
	/**保存联系人
	 * @return
	 */
	public String save(){
		try {
			baseService.save(t);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "addPage";
	}
	private Integer currPage=1;
	private Integer pageSize=3;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**根据条件查询,并且实现分页查询
	 * @return
	 */
	public String findAll(){
		try {
			PageBean<LinkMan> pagebean = baseService.findAll(t,currPage,pageSize);
			ActionContext.getContext().getValueStack().push(pagebean);
		}catch (CrmException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "listSuccess";
	}
	/**用于页面回显数据以及页面的跳转
	 * @return
	 */
	public String edit(){
		t = (T) baseService.findById(id);
		return "editPage";
	}
	/**用于对象的更新
	 * @return
	 */
	public String update(){
		try {
			baseService.update(t);
		} catch (Exception e) {
			e.printStackTrace();
			 return "error";
		}
	 return "opertionSuccess";
	}
	public String delete(){
		try {
			t = (T) baseService.findById(id);
			baseService.delete(t);
		} catch (Exception e) {
			e.printStackTrace();
			 return "error";
		}
		return "opertionSuccess";
	}
}
