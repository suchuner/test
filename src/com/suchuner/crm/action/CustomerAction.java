package com.suchuner.crm.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.suchuner.crm.domain.Customer;
import com.suchuner.crm.exception.CrmException;
import com.suchuner.crm.service.ICustomerService;
import com.suchuner.crm.utils.FileNameUtils;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class CustomerAction extends BaseAction<Customer>{

	private ICustomerService customerService;
	
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
		super.setBaseService(customerService);
	}
	/**添加客户,实现文件的上传功能
	 * @return
	 */
	/** 这三个属性是用struts上传必须要的属性,并且要符合规范*/
	private File uploadFile;//该名称与上传组件的名称需要一致;struts文件上传拦截器的实现要求
	private String uploadFileFileName;//该名称要求上传的组件名+FileName;
	private String uploadFileContentType;//该名称要求上传的组件名+ContentType;
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	
	public String addCustomer(){
		try {
			/*实现步骤:
			 * 1.如果文件存在,则为文件设置唯一名称
			 * 2.为文件设置分离目录
			 * 3.将文件保存到服务器的磁盘上
			 * 4.将文件的路径保存到数据库中
			 * */
			if(uploadFile!=null){
				String fileName =FileNameUtils.getUuidFileName(uploadFileFileName);//得到文件的唯一名称
				String dirs = FileNameUtils.getDirsForFile(fileName);
				String baseDir = "E:/upload";
				File file = new File(baseDir+dirs);
				if(!file.exists()){//判断当前目录是否存在,不存在则创建
					file.mkdirs();
				}
				String url =baseDir+dirs+fileName;//将文件拼接成完成的路径,用于创建该文件
				File newFile = new File(url);
				FileUtils.copyFile(uploadFile, newFile);
				getT().setCust_imgDir(url);
			}
			customerService.save(getT());
			this.addActionMessage("添加客户成功");
		} catch (CrmException e) {
			this.addActionError(e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "addPage";
	}
	
	
	/**实现客户的删除
	 * @return
	 */
	public String delete(){
		Customer cust = customerService.findById(getId());
		/* 需求:判断对象中是否存在上传的文件,如果存在则和对象一同删除
		 * */
		if(cust.getCust_imgDir()!=null&&!cust.getCust_imgDir().equals("")){
			File file = new File(cust.getCust_imgDir());//根据路径获取该文件对象,存在即删除
			if(file.exists()){
				file.delete();
			}
		}
		customerService.delete(cust);
		return "opertionSuccess";
	}
	
	public String update() {
		/*更新上传文件:如果上传的文件被更新,则需要考虑:
		 * 1.将原本上传的文件删除
		 * 2.将现在上传的文件保存到本地,思路与新增一样,唯一名称,分离.保存到本地,保存路径到数据库中
		 * */
		if(uploadFile!=null){
			String imgDir = getT().getCust_imgDir();
			if(!"".equals(imgDir)){
				File oldFile= new File(imgDir);
				if(oldFile.exists()){
					oldFile.delete();
				}
			}
			String fileName =FileNameUtils.getUuidFileName(uploadFileFileName);//得到文件的唯一名称
			String dirs = FileNameUtils.getDirsForFile(fileName);
			String baseDir = "E:/upload";
			File file = new File(baseDir+dirs);
			if(!file.exists()){//判断当前目录是否存在,不存在则创建
				file.mkdirs();
			}
			String url =baseDir+dirs+fileName;//将文件拼接成完成的路径,用于创建该文件
			File newFile = new File(url);
			try {
				FileUtils.copyFile(uploadFile, newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			getT().setCust_imgDir(url);
		}
		customerService.update(getT());
		return "opertionSuccess";
	}
	/**
	 * 用于异步传输的方法
	 */
	public void  ajaxListAll(){
		List<Customer> list = customerService.listAll();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"cust_phone","cust_mobile","cust_imgDir","baseDictSource","baseDictIndustry","baseDictLevel","linkMans"});
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 行业统计
	 */
	public void ajaxTotalIndustry(){
		List<Map<String,Long>> list = customerService.totalIndustry();
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 来源统计
	 */
	public void ajaxTotalSource(){
		List<Map<String,Long>> list = customerService.totalSource();
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
