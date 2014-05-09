<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<HTML>
<HEAD>
<TITLE>完了画面</TITLE>
<%@include file="/WEB-INF/common/common.jsp" %>
<link rel="stylesheet" href="cs/common.css" type="text/css">
<link rel="shortcut icon" href="/imag/favicon.ico" type="image/x-icon" />
</HEAD>
<BODY leftmargin="5" rightmargin="0" topmargin="20" marginwidth="0" marginheight="0">
<s:form action="Search" method="post" theme="simple" namespace="/emp">
  <TABLE WIDTH="985" cellpadding="0" cellspacing="0" border="0">
    <TR>
      <TD HEIGHT="30"></TD>
    </TR>
    <TR>
      <TD align="center">
          <font color="#FF6600" size="2">
            <B>
             <s:if test='#operateFlag eq "doAdd"'>
                <s:property value="%{getText('I00002')}"/>
             </s:if>
             <s:if test='#operateFlag eq "doUpdate"'>
                <s:text name="%{getText('I00003')}"/>
             </s:if>
             <c:if test="${operateFlag eq 'doDelete'}">
                <s:text name="%{getText('I00004')}"/>
             </c:if>
            </B>
          </font>
      </TD>
    </TR>
    <TR>
      <TD HEIGHT="20"></TD>
    </TR>
	<TR>
      <TD align="center">
         <c:if test="${operateFlag eq 'doAdd'}">
            <s:property value="%{getText('I00006')}"/>
         </c:if>
         <c:if test="${operateFlag eq 'doUpdate'}">
            <s:text name="%{getText('I00007')}"/>
         </c:if>
         <c:if test="${operateFlag eq 'doDelete'}">
            <s:text name="%{getText('I00008')}"/>
         </c:if>
      </TD>
    </TR>
	<TR>
      <TD HEIGHT="20"></TD>
    </TR>
	<TR>
      <TD align="center">
         <s:submit method="reappear" value="%{getText('button.back')}"/>
      </TD>
    </TR>
  </TABLE>
</s:form>
</BODY>
</HTML>
