<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<HTML>
<HEAD>
<TITLE>社員編集</TITLE>
<%@include file="/js/common-js.jsp" %>
<%@include file="/WEB-INF/common/common.jsp" %>
<link rel="stylesheet" href="cs/common.css" type="text/css">
<link rel="shortcut icon" href="/imag/favicon.ico" type="image/x-icon" />
</HEAD>
<BODY BGCOLOR="#ffffff" LINK="#0000ff" VLINK="#0000ff" MARGINWIDTH="0"
      MARGINHEIGHT="0" TOPMARGIN="0" LEFTMARGIN="0" RIGHTMARGIN="0"
      BOTTOMMARGIN="0" >
<s:form action="Update" method="post" namespace="/emp" theme="simple">
<TABLE border="0" width="488" CELLSPACING="5" CELLPADDING="0">
  <TBODY>
  <TR>
    <TD>
        <h6>　</h6>
        <b>社員編集</b><br><br>
        <TABLE border="1" bgcolor = "#cccccc" width="100%">
          <TBODY>
          <TR>
            <TD colspan="4" bgcolor="#ffffcc" >
              <s:submit method="updateConfirm" value="更新"/>
						  <s:submit method="reset" value="リセット"/>
						  <s:submit action="Search" method="reappear" value="キャンセル"/>
						  <s:submit method="deleteConfirm" value="削除"/>
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#ffcc99" width="11%" height="13" nowrap>番号</TD>
            <TD bgcolor="#ffffff" height="13" colspan="3">
               <s:property value="empDto.empno"/>
               <s:hidden name="empDto.empno"/>
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#ffcc99" nowrap width="11%"><font color="#FF0000">氏名</font></TD>
            <TD bgcolor="#ffffff" colspan="3">
               <s:textfield name="empDto.ename" size="20" maxlength="25" styleClass="input-zenkaku"/>
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#ffcc99" height="28" nowrap>仕事</TD>
            <TD bgcolor="#ffffff" height="28" colspan="3">
               <s:textfield name="empDto.job" size="40" maxlength="54" styleClass="input-zenkaku"/>
          </TR>
          <TR>
            <TD bgcolor="#ffcc99" height="28" nowrap>上司</TD>
            <TD bgcolor="#ffffff" height="28" colspan="3">
              <s:select id="mgrno" name="empDto.mgrno" list="mgrList" value="empDto.mgrno"
                         headerKey="-1" headerValue="" listKey="mgrno" listValue="mname" />
            	<s:hidden id="hidden_mgrname" name="empDto.mgrname"/> 
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#ffcc99" height="28" nowrap>給料</TD>
            <TD bgcolor="#ffffff" height="28" colspan="3">
              <s:textfield id="sal" name="empDto.sal" size="9" maxlength="8"
                         style="text-align: right" styleClass="input-number"/>
                                  賞与
              <s:textfield id="comm" name="empDto.comm" size="9" maxlength="8"
                         style="text-align: right" styleClass="input-number"/>
              &nbsp;<label id="sum"></label>
              <s:hidden id="hiden_sum" name="empDto.sum"/>
             </TD>
          </TR>
           <TR>
            <TD bgcolor="#ffcc99" height="28" nowrap>雇用日付</TD>
            <TD bgcolor="#ffffff" height="28" colspan="3">
              <s:textfield name="empDto.hiredate" size="12" maxlength="10" styleClass="input-zenkaku"/>
              <b>(YYYY/MM/DD)</b>
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#ffcc99" height="28" nowrap>所属部門</TD>
            <TD bgcolor="#ffffff" height="28" colspan="3">
                <s:select id="deptno" name="empDto.deptno" list="deptList"
                          headerKey="-1" headerValue="" listKey="deptno" listValue="dname"/>
                <s:hidden id="loc" name="empDto.local"/>
                <label id="local"></label>
                <s:hidden id="hiden_dname" name="empDto.dname"/>
								<s:hidden id="hiden_local" name="empDto.local"/>
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#ffcc99" height="28" nowrap width="11%">メモ</TD>
            <TD bgcolor="#ffffff" height="28" colspan="3">
            	<s:textarea name="empDto.memo" cols="60" rows="4"/>
            </TD>
          </TR>
          <TR>
            <TD colspan="4" bgcolor="#ffffcc">
              <s:submit method="updateConfirm" value="更新"/>
						  <s:submit method="reset" value="リセット"/>
						  <s:submit action="Search" method="reappear" value="キャンセル"/>
						  <s:submit method="deleteConfirm" value="削除"/>
	      </TD>
          </TR>
          </TBODY>
        </TABLE>
      </TD>
    </TR>
  </TBODY>
</TABLE>
</s:form>
</BODY>
</HTML>
