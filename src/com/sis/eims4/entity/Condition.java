package com.sis.eims4.entity;

import java.io.Serializable;

/**
 * 検索条件
 * @author test01
 *
 */
public class Condition implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//氏名
	private String ename;
	//部門ID
	private int deptno;
	//雇用日付
	private String hiredate;
	//給料範囲(FROM)
	private String salFrom;
	//給料範囲(TO)
	private String salTo;
	//賞与有り
	private boolean hasComm;
	//ページ
	private Pagination pagination;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getSalFrom() {
		return salFrom;
	}
	public void setSalFrom(String salFrom) {
		this.salFrom = salFrom;
	}
	public String getSalTo() {
		return salTo;
	}
	public void setSalTo(String salTo) {
		this.salTo = salTo;
	}

	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public boolean isHasComm() {
		return hasComm;
	}
	public void setHasComm(boolean hasComm) {
		this.hasComm = hasComm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
