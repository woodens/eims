<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>初めましで</title>
<%@include file="/WEB-INF/common/common.jsp" %>
<link rel="stylesheet" href="cs/common.css" type="text/css">
<link rel="shortcut icon" href="imag/favicon.ico" type="image/x-icon" />
<script type="text/javascript">
	$(function() {
		getLocal();
		$("#dept").change(getLocal);
	});
	function getLocal() {
		$.ajax({
			type : "POST",
			url : "local.action",
			dataType : "json",
			data : "dept.deptno=" + $("#dept").val(),
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert('Error ' + textStatus);
				alert(errorThrown);
				alert(XMLHttpRequest.responseText);
			},
			success : function(data) {
				$("#local").html(data.loc);
			}
		});
	}
	/**function getXhr(){
		var xhr = null;
		if(window.XMLHttpRequest){
			xhr = new XMLHttpRequest();//非IE浏览器
		}else{
			xhr = new ActveObject('Microsoft.XMLHttp');//IE浏览器
		}
		return xhr;
	}
	function getLocal(deptno){
		var xhr = getXhr();//获取Ajax对象
		//使用Ajax对象发送请求
		var url = "local.action?deptno="+deptno;
		xhr.open('get', url, true);
		//绑定一个事件处理函数，里面的代码在状态改变时执行，且状态为4时执行if语句
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){//只有readState为4时，Ajax对象才会获得服务器返回的所有数据
				if(xhr.status==200){
					var txt = xhr.responseText;
					var obj = txt.evalJSON();
					$("#deptname").text(obj);
					alert(obj);
				}else{
					return;
				}
			}
		};
		$("#deptname").text("正在发送....");
		xhr.send(null);
	}
	 **/
</script>
</head>
<body id="body" bgcolor="#ffffff" link="#0000ff" vlink="#CC0000"
	MARGINWIDTH="0" MARGINHEIGHT="0" TOPMARGIN="0" LEFTMARGIN="0"
	RIGHTMARGIN="0" BOTTOMMARGIN="0">
	<s:form action="Search" method="post" theme="simple" namespace="/emp">
		<table border="0" width="730" cellpadding="0" cellspacing="5">
			<tbody>
				<tr>
					<td>
						<h6></h6>
						<table width="100%" border="0">
							<tr>
								<td width="13%" nowrap>社員名</td>
								<td colspan="4">
									<s:textfield name="condition.ename" size="40" maxlength="20" styleClass="input-zenkaku" />
								</td>
							</tr>
							<tr>
								<td nowrap>所属部門</td>
								<td width="26%">
									<div>
										<s:select id="dept" name="condition.deptno" list="deptList"
											headerKey="0" headerValue="" listKey="deptno"
											listValue="dname" onchange="getLocal()" />
										<label id="local"></label>
									</div>
								</td>
								<td width="17%">&nbsp;</td>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td nowrap>雇用日</td>
								<td colspan="4">
									<s:radio name="condition.hiredate"
										list="#{'before':'2000年前','after':'2000年以後','empty':'未登録'}"
										listKey="key" listValue="value"/>
								</td>
							</tr>
							<tr>
								<td valign="top" nowrap>給料範囲</td>
								<td valign="top" nowrap>
									<s:textfield name="condition.salFrom" size="9" maxlength="8"
										styleClass="input-number" /> ～
									<s:textfield name="condition.salTo" size="9" maxlength="8"
										styleClass="input-number" /> 円
								</td>
								<td valign="top" nowrap>&nbsp;&nbsp;&nbsp;
									<s:checkbox name="condition.hasComm" />賞与有り
								</td>
								<td width="14%">&nbsp;</td>
								<td width="30%" nowrap>
									<s:submit value="%{getText('button.search')}" method="search"
										style="width:96px;" /> 
									<s:submit value="%{getText('button.reset')}" method="reset"
										style="width:96px;" />
								</td>
							</tr>
						</table>
						<ul style="color: red">
							<s:fielderror />
						</ul> 
						<s:if test="condition.pagination==null">
							<font size="-1"> <br>
							</font>
						</s:if> 
						<s:if test="condition.pagination!=null">
							<font size="-1"> <br>検索結果(${condition.pagination.countItem}件)
							</font>
						</s:if>
						<table border="1" width="100%" bgcolor="#cccccc">
							<tbody>
								<tr bgcolor="#FFFFCC">
									<td colspan="5">
										<span style="float: left"> 
											<s:submit action="Add" method="access"
												value="%{getText('button.add')}" style="width:70px;" />
										</span> 
										<span style="float: right"> 
											<s:submit method="excelDownLoad"
												value="%{getText('button.excelDownLoad')}"
												disabled="%{empList==null}" style="width:80px;" /> <s:submit
												method="csvDownLoad"
												value="%{getText('button.csvDownLoad')}"
												disabled="%{empList==null}" style="width:80px;" />
										</span>
									</td>
								</tr>
								<s:if test="empList!=null">
									<tr bgcolor="#ffcc99">
										<td width="130" align="center">社員名</td>
										<td width="80" align="center">仕事</td>
										<td width="119" align="center">上司</td>
										<td width="108" align="center">年俸</td>
										<td width="249" align="center">所属部門</td>
									</tr>
									<s:iterator var="empDto" value="empList">
										<tr bgcolor="#ffffff">
											<td>
												<a href="Update!access.action?empDto.empno=${empno}">
													<s:property value="ename" />
												</a>
											</td>
											<td><s:property value="job" /></td>
											<td><s:property value="mgrname" /></td>
											<td align="right">
												<fmt:formatNumber value="${annualSal}" type="number" pattern="#,###.##" />
											</td>
											<td><s:property value="dname" /></td>
										</tr>
									</s:iterator>
									<tr bgcolor="#ffffcc">
										<td colspan="5">&nbsp;</td>
									</tr>
								</s:if>
							</tbody>
						</table>

						<table width="100%" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td height="5"></td>
							</tr>
							<s:if test="condition.pagination!=null">
								<tr>
									<s:if test="condition.pagination.page gt 1">
										<td align="left">
											<a href="Search!turnPage.action?page=${condition.pagination.prePage}">前へ</a>
										</td>
									</s:if>
									<s:if
										test="condition.pagination.page lt condition.pagination.maxPage">
										<td align="right">
											<a href="Search!turnPage.action?page=${condition.pagination.nextPage}">次へ</a>
										</td>
									</s:if>
								</tr>
							</s:if>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</s:form>
</body>
</html>
