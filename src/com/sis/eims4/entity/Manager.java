package com.sis.eims4.entity;

import java.io.Serializable;

/**
 * 上司情報
 * @author test01
 *
 */
public class Manager implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//上司ID
	private int mgrno;
	//上司氏名
	private String mname;
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMgrno() {
		return mgrno;
	}
	public void setMgrno(int mgrno) {
		this.mgrno = mgrno;
	}
}
