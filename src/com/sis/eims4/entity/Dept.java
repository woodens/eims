package com.sis.eims4.entity;

import java.io.Serializable;

/**
 * 部門(DB)情報
 * @author test01
 *
 */
public class Dept implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//部門ID
	private int deptno;
	//部門名
	private String dname;
	//所在位置
	private String loc;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
