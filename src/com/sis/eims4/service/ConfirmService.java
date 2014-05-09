package com.sis.eims4.service;

import java.util.List;

import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;

public interface ConfirmService {
	/**
	 * 検索部門情報
	 * @param empno          部門ID
	 * @return               部門情報
	 * @throws Exception
	 */
	public Dept findDeptById(int deptno)throws Exception;
	/**
	 * 検索部門情報
	 * @return               部門情報
	 * @throws Exception
	 */
	public List<Dept> findDepts() throws Exception;

	/**
	 * 検索上司情報
	 * @return               上司情報
	 * @throws Exception
	 */
	public List<Manager> findMgrs() throws Exception;

	/**
	 * 社員更新
	 * @param confirmForm   フォーム情報
	 * @return              成否
	 * @throws Exception
	 */
	public boolean update(EmpDto empDtos)throws Exception;
	/**
	 * 社員削除
	 * @param empno         社員ID
	 * @return              成否
	 * @throws Exception
	 */
	public boolean delete(int empno)throws Exception;
	/**
	 * 登録（INSERT)を行
	 * @param EmpDto        社員情報
	 * @return              成否
	 * @throws Exception
	 */
	public boolean insert(EmpDto empDto)throws Exception;

}
