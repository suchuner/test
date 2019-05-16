<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html >
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
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
<SCRIPT type="text/javascript" >
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}
</SCRIPT>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/customer_findAll"
		method=post>
		
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
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="t.cust_name"  value="${t.cust_name}"></TD>
														
													<td>客户级别 ：</td>
								<td>
								<select id='customerLevel' name="t.baseDictLevel.dict_id">
									<option value="">--请选择--</option>
								</select>
								
								<td>信息来源 ：</td>
								<td>
								<select id='customerSource' name="t.baseDictSource.dict_id">
									<option value="">--请选择--</option>
								</select>
								</td>
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<s:actionerror/>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator value="list">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${cust_name }</TD>
													<TD>${baseDictLevel.dict_item_name}</TD>
													<TD>${baseDictSource.dict_item_name}</TD>
													<TD>${cust_phone }</TD>
													<TD>${cust_mobile }</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/customer_edit?id=${cust_id}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/customer_delete?id=${cust_id}" >删除</a>
													</TD>
												</TR>
												
												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${totalCount}</B>]条记录,[<B>${totalPage}</B>]页
												,每页显示
												<select name="pageSize" onchange="to_page(1)">
												<option value="3"  <s:if test="pageSize==3">selected</s:if>>3</option>
												<option value="10"  <s:if test="pageSize==10">selected</s:if>>10</option>
												<option value="15"  <s:if test="pageSize==15">selected</s:if>>15</option>
												</select>
												条
												<s:if test="currPage!=1">
												[<A href="javascript:to_page(1)">首页</A>]
												<B>${page}</B>
												[<A href="javascript:to_page(${currPage-1})">前一页</A>] 
												</s:if>
												<s:if test="totalPage!=null">
												<s:iterator var ="i"  begin="1" end="totalPage">
													<s:if test="#i==currPage">${i}</s:if><!-- var 值不在栈顶,用struts标签时需要用#取值 -->
													<s:else><A href="javascript:to_page(${i})">${i}</A></s:else>
												</s:iterator>
												</s:if>
												<s:if test="currPage!=totalPage">
													[<A href="javascript:to_page(${currPage+1})">后一页</A>]
												<B>${page}</B>
												[<A href="javascript:to_page(${totalPage})">尾页</A>] 
												</s:if>
												到
												<input type="text" size="3" id="page" name="currPage"  value="1"/>
												页
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
	</FORM>
</BODY>
</HTML>
