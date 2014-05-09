package com.sis.eims4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sis.eims4.dao.AddDao;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.util.DBUtil;
/**
 * 社員新規
 * @author test01
 *
 */
public class AddDaoImpl implements AddDao{

	/**
	 * 登録（INSERT)を行
	 * @param Emp           社員情報
	 * @return              成否
	 * @throws Exception
	 */
	public boolean insert(EmpDto empDto) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into WEB_EMP " +
					"values((SELECT NEXTVAL()),?,?,?,?,?,?,?,?,sysdate())";

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
		int result = ps.executeUpdate();
		DBUtil.close(conn, ps);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

}
