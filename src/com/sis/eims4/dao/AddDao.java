package com.sis.eims4.dao;

import com.sis.eims4.entity.EmpDto;
/**
 * 社員新規
 * @author test01
 *
 */
public interface AddDao {
	/**
	 * 登録（INSERT)を行
	 * @param emp           社員情報
	 * @return              成否
	 * @throws Exception
	 */
	public boolean insert(EmpDto empDto)throws Exception;

}
