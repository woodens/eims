package com.sis.eims4.entity;

import java.io.Serializable;

/**
 * 社員(検索結果、新規)情報
 * @author test01
 *
 */
public class EmpDto implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//社員ID
	private int empno;
	//氏名
	private String ename;
	//仕事
	private String job;
	//上司ID
	private int mgrno;
	//上司
	private String mgrname;
	//給料
	private String sal;
	//賞与
	private String comm;
	//合計
	private String sum;
	//雇用日付
	private String hiredate;
	//年俸
	private String annualSal;
	//部門ID
	private int deptno;
	//部門名
	private String dname;
	//所在位置
	private String local;
	//メモ
	private String memo;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public void setAnnualSal(String annualSal) {
		this.annualSal = annualSal;
	}
	public String getSal() {
		return sal;
	}
	public String getComm() {
		return comm;
	}
	public String getHiredate() {
		return hiredate;
	}
	public String getAnnualSal() {
		return annualSal;
	}
	public int getMgrno() {
		return mgrno;
	}
	public void setMgrno(int mgrno) {
		this.mgrno = mgrno;
	}
	public String getMgrname() {
		return mgrname;
	}
	public void setMgrname(String mgrname) {
		this.mgrname = mgrname;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
}
