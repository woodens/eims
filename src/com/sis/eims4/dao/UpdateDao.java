package com.sis.eims4.dao;

import com.sis.eims4.entity.EmpDto;

/**
 * 社員更新
 * @author test01
 *
 */
public interface UpdateDao {

	/**
	 * 社員削除
	 * @param empno         社員ID
	 * @return              成否
	 * @throws Exception
	 */
	public boolean delete(int empno)throws Exception;

	/**
	 * 社員更新
	 * @param emp           社員情報
	 * @return              成否
	 * @throws Exception
	 */
	public boolean update(EmpDto empDto)throws Exception;


}
