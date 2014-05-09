package com.sis.eims4.service.impl;

import java.util.List;

import com.sis.eims4.dao.SearchDao;
import com.sis.eims4.dao.impl.SearchDaoImpl;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;
import com.sis.eims4.service.UpdateService;
 /**
 * 社員更新
 * @author SIS
 *
 */
public class UpdateSerImpl implements UpdateService{
	private SearchDao searchDao = new SearchDaoImpl();

	/**
	 * 検索社員情報
	 * @param empno         社員ID
	 * @return              社員情報
	 * @throws Exception
	 */

	public EmpDto findEmpById(int empno) throws Exception {
		return searchDao.findEmpById(empno);

	}

	/**
	 * 検索部門情報
	 * @return               部門情報
	 * @throws Exception
	 */

	public List<Dept> findDepts() throws Exception {
		return searchDao.findDepts();
	}

	/**
	 * 検索上司情報
	 * @return               上司情報
	 * @throws Exception
	 */

	public List<Manager> findMgrs() throws Exception {
		return searchDao.findMgrs();
	}

	/**
	 * 検索部門情報
	 * @param empno          部門ID
	 * @return               部門名
	 * @throws Exception
	 */

	public Dept findDeptById(int deptno)throws Exception {
		return searchDao.findDeptById(deptno);
	}

	/**
	 * 検索上司情報
	 * @param empno         上司ID
	 * @return              上司情報
	 * @throws Exception
	 */

	public Manager findMgrById(int mgrno) throws Exception{
		return searchDao.findMgrById(mgrno);
	}

}
