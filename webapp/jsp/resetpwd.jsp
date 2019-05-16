<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<TITLE>修改密码</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/basedic.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
<script type="text/javascript">
function resetPwd(){
	/*先判断空值,再判断值的正确性  */
	var oldpwd=$("#oldPwd").val();
	if($.trim(oldpwd)==null||$.trim(oldpwd)==""){
		$("#msg").html("原密码未填写");
		return;
	}else{
		var pwd="${session.loginUser.user_password}";
		if(hex_md5(oldpwd)!=pwd){
			$("#msg").html("原密码错误!");
			return;
		}
	}
	var newpwd=$("#newPwd").val();
	if($.trim(newpwd)==null||$.trim(newpwd)==""){
		$("#msg").html("新密码未填写");
		return;
	}
	var confirmPwd=$("#confirmPwd").val();
	if($.trim(newpwd)!=confirmPwd){
		$("#msg").html("两次密码不一致");
		return;
	}
	document.form1.submit();
}
</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/user_resetPwd"
		method=post  >
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
								<TD class=manageHead>当前位置：用户管理 &gt; 修改密码</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						    <s:actionerror/>
						    <s:actionmessage/>
						    <s:fielderror />
						    <span id='msg' ></span>
							<TR>
								<td>当前密码：</td>
								<td>
								<INPUT class=textbox  type="password"
														style="WIDTH: 180px" maxLength=50 id="oldPwd" name="oldPwd">
								</td>
								<td>新密码：</td>
								<td>
								<INPUT class=textbox type="password"
														style="WIDTH: 180px" maxLength=50  id="newPwd" name="t.user_password">
								</td>
								<td>确认密码：</td>
								<td>
								<INPUT class=textbox type="password"
														style="WIDTH: 180px" maxLength=50 id="confirmPwd">
								</td>
							<tr>
								<td rowspan=2>
								<button type="button"  onclick="resetPwd()" >修改</button>
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
	</FORM>
</BODY>
</HTML>
