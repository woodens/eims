package com.sis.eims4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sis.eims4.dao.UpdateDao;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.util.DBUtil;
/**
 * 社員更新
 * @author test01
 *
 */
public class UpdateDaoImpl implements UpdateDao{

	/**
	 * 社員削除
	 * @param empno         社員ID
	 * @return              成否
	 * @throws Exception
	 */

	public boolean delete(int empno) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from WEB_EMP " +
	                  "where EMPNO=?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, empno);
		int result = ps.executeUpdate();
		DBUtil.close(conn, ps);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 社員更新
	 * @param emp           社員情報
	 * @return              成否
	 * @throws Exception
	 */

	public boolean update(EmpDto empDto) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "update WEB_EMP " +
	                    "set ENAME=?" +
	                       ",JOB=?" +
	                       ",MGR=?" +
	                       ",HIREDATE=?" +
	                       ",SAL=?" +
	                       ",COMM=?" +
	                       ",DEPTNO=?" +
	                       ",MEMO=?" +
	                       ",UPD_TIME=sysdate() "+
	                  "where EMPNO=?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,empDto.getEname());
		ps.setString(2, empDto.getJob());
		ps.setString(3, Integer.toString(empDto.getMgrno()));
		ps.setString(4, empDto.getHiredate());
		ps.setString(5, empDto.getSal());
		ps.setString(6, empDto.getComm());
		if(empDto.getDeptno()!=0){
			ps.setString(7, Integer.toString(empDto.getDeptno()));
		}else{
			ps.setString(7, "");
		}

		ps.setString(8, empDto.getMemo());
		ps.setString(9, Integer.toString(empDto.getEmpno()));
		int result = ps.executeUpdate();
		DBUtil.close(conn, ps);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}



}
