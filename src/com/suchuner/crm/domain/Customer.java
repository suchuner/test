package com.suchuner.crm.domain;

import java.util.List;

public class Customer {
	private Long cust_id;//客户编号(主键)
	private String cust_name;//客户名称(公司名称)
	/*private String cust_source;//客户信息来源
	private String cust_industry;//客户所属行业
	private String cust_level;//客户级别
*/	private String cust_phone;//固定电话
	private String cust_mobile;//移动电话
	private String cust_imgDir;//上传图片保存的路径
	
	private BaseDict baseDictSource;
	private BaseDict baseDictIndustry;
	private BaseDict baseDictLevel;
	
	private List<SaleVisit> saleVisits;
	
	public List<SaleVisit> getSaleVisits() {
		return saleVisits;
	}
	public void setSaleVisits(List<SaleVisit> saleVisits) {
		this.saleVisits = saleVisits;
	}
	private List<LinkMan> linkMans;//联系人
	public List<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(List<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}
	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}
	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}
	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}
	public String getCust_imgDir() {
		return cust_imgDir;
	}
	public void setCust_imgDir(String cust_imgDir) {
		this.cust_imgDir = cust_imgDir;
	}
	
}
