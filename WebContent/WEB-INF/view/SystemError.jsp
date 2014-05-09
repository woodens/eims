<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<HTML>
<HEAD>
<TITLE>エラー画面</TITLE>
<%@include file="/WEB-INF/common/common.jsp" %>
<link rel="stylesheet" href="cs/common.css" type="text/css">
<link rel="shortcut icon" href="/imag/favicon.ico" type="image/x-icon" />
</HEAD>
<BODY BGCOLOR="#ffffff" LINK="#0000ff" VLINK="#CC0000" MARGINWIDTH="0" MARGINHEIGHT="0"
      TOPMARGIN="0" LEFTMARGIN="0" RIGHTMARGIN="0" BOTTOMMARGIN="0">
 <s:form action="Error" theme="simple" method="post" namespace="/emp">
 <s:hidden name="empDto.empno"/>
 <s:hidden name="empDto.ename"/>
 <s:hidden name="empDto.job"/>
 <s:hidden name="empDto.mgrname"/>
 <s:hidden name="empDto.mgrno"/>
 <s:hidden name="empDto.sal"/>
 <s:hidden name="empDto.comm"/>
 <s:hidden name="empDto.sum"/>
 <s:hidden name="empDto.hiredate"/>
 <s:hidden name="empDto.dname"/>
 <s:hidden name="empDto.deptno"/>
 <s:hidden name="empDto.memo"/>
<TABLE border="0" width="730" cellpadding="0" cellspacing="5">
  <TBODY>
  <TR>
    <TD align="center">
        <h6> </h6>
        <table width="100%" border="0">
          <tr>
            <td align="center">
            <font color="red" size="3">
            <s:if test="#session.errorFlag eq 'inputError'">
                <s:text name="E00015"/>
            </s:if>
             <s:if test="#session.errorFlag eq 'conformError'">
                <s:text name="E00016"/>
            </s:if>
             <s:if test="#session.errorFlag eq 'systemError'">
                <s:text name="E00017"/>
            </s:if>
             <s:if test="#session.errorFlag eq 'urlError'">
                <s:text name="E00017"/>
            </s:if>
            </font>
            </td>
        </tr>
          <tr>
            <td><br></td>
          </tr>
          <tr>
            	<td align="center">
                  <br><s:fielderror/><br>
                </td>
          </tr>
          <tr>
            <td align="center">
            <s:if test="#session.errorFlag eq 'inputError'">
                <s:submit method="back" value="%{getText('button.back')}" style="width:96px;"/>
            </s:if>
            <s:if test="#session.errorFlag eq 'conformError'">
                <s:submit method="back" value="%{getText('button.back')}" style="width:96px;"/>
            </s:if>
             <s:if test="#session.errorFlag eq 'systemError'">
                <s:submit method="close" value="%{getText('button.close')}"  style="width:96px;"/>
            </s:if>
             <s:if test="#session.errorFlag eq 'urlError'">
                  <s:submit method="close" value="%{getText('button.close')}"  style="width:96px;"/>
            </s:if>
            </td>
          </tr>

        </table><BR>
</TD>
</TR>
</TBODY>
</TABLE>
</s:form>
</BODY>
</HTML>
