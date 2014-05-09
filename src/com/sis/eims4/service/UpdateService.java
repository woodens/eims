package com.sis.eims4.service;

import java.util.List;

import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;
/**
 * 社員更新
 * @author test01
 *
 */
public interface UpdateService {
	/**
	 * 検索社員情報
	 * @param empno         社員ID
	 * @return              社員情報
	 * @throws Exception
	 */
	public EmpDto findEmpById(int empno)throws Exception;

	/**
	 * 検索部門情報
	 * @return               部門情報
	 * @throws Exception
	 */
	public List<Dept> findDepts()throws Exception;

	/**
	 * 検索上司情報
	 * @return               上司情報
	 * @throws Exception
	 */
	public List<Manager> findMgrs()throws Exception;
	/**
	 * 検索部門情報
	 * @param empno          部門ID
	 * @return               部門情報
	 * @throws Exception
	 */
	public Dept findDeptById(int deptno)throws Exception;
	/**
	 * 検索上司情報
	 * @param empno         上司ID
	 * @return              上司氏名
	 * @throws Exception
	 */
	public Manager findMgrById(int mgrno)throws Exception;
}
