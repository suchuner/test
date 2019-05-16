<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<TITLE>更改客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" >
$(function(){
	$.post("baseDict_findByTypeCode",{"dict_type_code":"002"},function(data){
		$(data).each(function(i,obj){
		$("#customerSource").append("<option value = '"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
		});
		$("#customerSource option[value ='${t.baseDictSource.dict_id}']").prop("selected","selected");
	},"json");
	$.post("baseDict_findByTypeCode",{"dict_type_code":"006"},function(data){
		$(data).each(function(i,obj){
		$("#customerLevel").append("<option value = '"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
		});
		$("#customerLevel option[value ='${t.baseDictLevel.dict_id}']").prop("selected","selected");
	},"json");
	$.post("baseDict_findByTypeCode",{"dict_type_code":"001"},function(data){
		$(data).each(function(i,obj){
		$("#customerIndustry").append("<option value = '"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
		});
		$("#customerIndustry option[value ='${t.baseDictIndustry.dict_id}']").prop("selected","selected");
	},"json");
});
</script>
</HEAD>
<BODY>
<s:debug />
<s:form id="form1" name="form1" 
			 action="customer_update" namespace="/" 
 			enctype="multipart/form-data" 
		 method="post"   theme="simple" >
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 更改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						    <s:actionerror/>
						    <s:actionmessage/>
						    <s:fielderror />
						    <s:hidden name="t.cust_id" value="%{t.cust_id}" />
						    <s:hidden name="t.cust_imgDir" value="%{t.cust_imgDir}"/>
							<TR>
								<td>客户名称：</td>
								<td>
								<s:textfield cssClass="textbox" cssStyle="WIDTH: 180px" maxLength="50" name="t.cust_name" value="%{t.cust_name}"/>
								</td>
								<td>客户级别 ：</td>
								<td>
								<select id='customerLevel' name="t.baseDictLevel.dict_id">
									<option value="">--请选择--</option>
								</select>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td>
								<select id='customerSource' name="t.baseDictSource.dict_id">
									<option value="">--请选择--</option>
								</select>
								</td>
								<td>所属行业 ：</td>
								<td>
								<select id='customerIndustry' name="t.baseDictIndustry.dict_id">
									<option value="">--请选择--</option>
								</select>
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<s:textfield cssClass="textbox" id="sChannel2" cssStyle="WIDTH: 180px" maxLength="50" name="t.cust_phone" value="%{t.cust_phone}"/>
								</td>
								<td>移动电话 ：</td>
								<td>
								<s:textfield cssClass="textbox" id="sChannel2" cssStyle="WIDTH: 180px" maxLength="50" name="t.cust_mobile" value="%{t.cust_mobile}"/>
								</td>
							</TR>
							<tr>
							<td>客户资质 ：</td>
								<td>
									<INPUT class=textbox   type=file
														style="WIDTH: 180px" maxLength=50 name="uploadFile">
								</td>
							</tr>
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</s:form>
</BODY>
</HTML>
