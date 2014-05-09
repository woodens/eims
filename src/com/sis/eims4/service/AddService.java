package com.sis.eims4.service;

import java.util.List;

import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;
/**
 * 社員新規
 * @author SIS
 *
 */
public interface AddService {
	/**
	 * 検索上司情報
	 * @return             上司情報
	 * @throws Exception
	 */
	public List<Manager> findMgrs()throws Exception;
	/**
	 * 登録（INSERT)を行
	 * @param emp           社員
	 * @return              成否
	 * @throws Exception
	 */
	public boolean insert(EmpDto empDto)throws Exception;
	/**
	 * 検索部門情報
	 * @return               部門情報
	 * @throws Exception
	 */
	public List<Dept> findDepts()throws Exception;
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
