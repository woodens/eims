<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<HTML>
<HEAD>
<TITLE>社員確認</TITLE>
<%@include file="/WEB-INF/common/common.jsp" %>
<link rel="stylesheet" href="cs/common.css" type="text/css">
<link rel="shortcut icon" href="/imag/favicon.ico" type="image/x-icon" />
</HEAD>
<BODY BGCOLOR="#ffffff" LINK="#0000ff" VLINK="#0000ff" MARGINWIDTH="0"
	MARGINHEIGHT="0" TOPMARGIN="0" LEFTMARGIN="0" RIGHTMARGIN="0"
	BOTTOMMARGIN="0">
	<s:form action="Confirm" method="post" theme="simple" namespace="/emp">
		<TABLE border="0" width="488" CELLSPACING="5" CELLPADDING="0">
			<TBODY>
				<TR>
					<TD>
						<h6></h6> <s:if test="#session.operateFlag eq 'doAdd'">
							<b>社員新規確認</b>
							<br>
							<br>
						</s:if> <s:if test="#session.operateFlag eq 'doUpdate'">
							<b>社員更新確認</b>
							<br>
							<br>
						</s:if> <s:if test="#session.operateFlag eq 'doDelete'">
							<b>社員削除確認</b>
							<br>
							<br>
						</s:if>
						<TABLE border="1" bgcolor="#cccccc" width="100%">
							<TBODY>
								<TR>
									<TD colspan="4" bgcolor="#ffffcc">
										<s:if test="#session.operateFlag eq 'doAdd'">
											<s:submit method="confirm" value="%{getText('button.addConfirm')}" />
										</s:if> 
										<s:if test="#session.operateFlag eq 'doUpdate'">
											<s:submit method="confirm" value="%{getText('button.updateConfirm')}" />
										</s:if> 
										<s:if test="#session.operateFlag eq 'doDelete'">
											<s:submit method="confirm" value="%{getText('button.deleteConfirm')}" />
										</s:if> 
										<s:submit method="cancel" value="%{getText('button.cancel')}" />
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#ffcc99" width="11%" height="13" nowrap>番号</TD>
									<TD bgcolor="#ffffff" height="13" colspan="3">
										<s:if test="empDto.empno eq 0"></s:if> 
										<s:else>
											<s:text name="empDto.empno" />
										</s:else> 
										<s:hidden name="empDto.empno" />
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#ffcc99" nowrap width="11%">
									<font color="#FF0000">氏名</font></TD>
									<TD bgcolor="#ffffff" colspan="3">
									<s:text name="empDto.ename" /> 
									<s:hidden name="empDto.ename" /></TD>
								</TR>
								<TR>
									<TD bgcolor="#ffcc99" height="28" nowrap>仕事</TD>
									<TD bgcolor="#ffffff" height="28" colspan="3">
									<s:text name="empDto.job" /> 
									<s:hidden name="empDto.job" /></TD>
								</TR>
								<TR>
									<TD bgcolor="#ffcc99" height="28" nowrap>上司</TD>
									<TD bgcolor="#ffffff" height="28" colspan="3">
										<s:text name="empDto.mgrname" /> 
										<s:hidden name="empDto.mgrno" />
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#ffcc99" height="28" nowrap>給料</TD>
									<TD bgcolor="#ffffff" height="28" colspan="3">
										<fmt:formatNumber value="${empDto.sal}" type="number" pattern="##,###,###.##" />
										<s:hidden name="empDto.sal" /> &nbsp;賞与&nbsp; 
										<fmt:formatNumber value="${empDto.comm}" type="number" pattern="##,###,###.##" />
										<s:hidden name="empDto.comm" /> &nbsp; 
										<fmt:formatNumber value="${empDto.sum}" type="number" pattern="##,###,###.##" />
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#ffcc99" height="28" nowrap>雇用日付</TD>
									<TD bgcolor="#ffffff" height="28" colspan="3">
										<s:text name="empDto.hiredate" /> 
										<s:hidden name="empDto.hiredate" />
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#ffcc99" height="28" nowrap>所属部門</TD>
									<TD bgcolor="#ffffff" height="28" colspan="3">
										<s:property value="empDto.dname" /> &nbsp; 
										<s:property value="empDto.local" /> 
										<s:hidden name="empDto.deptno" />
									</TD>
								</TR>
								<TR>
									<TD bgcolor="#ffcc99" height="28" nowrap width="11%">メモ</TD>
									<TD bgcolor="#ffffff" height="28" colspan="3">
										<s:text name="empDto.memo" /> 
										<s:hidden name="empDto.memo" />
									</TD>
								</TR>
								<TR>
									<TD colspan="4" bgcolor="#ffffcc">
										<s:token name="hello" />
										<s:if test="#session.operateFlag eq 'doAdd'">
											<s:submit method="confirm" value="%{getText('button.addConfirm')}" />
										</s:if> 
										<s:if test="#session.operateFlag eq 'doUpdate'">
											<s:submit method="confirm" value="%{getText('button.updateConfirm')}" />
										</s:if> 
										<s:if test="#session.operateFlag eq 'doDelete'">
											<s:submit method="confirm" value="%{getText('button.deleteConfirm')}" />
										</s:if> 
										<s:submit method="cancel" value="%{getText('button.cancel')}" />
									</TD>
								</TR>
							</TBODY>
						</TABLE> <BR>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</s:form>
</BODY>
</HTML>
