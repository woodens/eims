package com.sis.eims4.service.impl;

import java.util.List;

import com.sis.eims4.dao.AddDao;
import com.sis.eims4.dao.SearchDao;
import com.sis.eims4.dao.impl.AddDaoImpl;
import com.sis.eims4.dao.impl.SearchDaoImpl;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;
import com.sis.eims4.service.AddService;
/**
 * 社員新規
 * @author test01
 *
 */
public class AddSerImpl implements AddService{
	private SearchDao searchDao = new SearchDaoImpl();
	private AddDao addDao = new AddDaoImpl();

	/**
	 * 検索上司情報
	 * @return             上司情報
	 * @throws Exception
	 */

	public List<Manager> findMgrs() throws Exception {
		List<Manager> list =  searchDao.findMgrs();
		return list;
	}

	/**
	 * 登録（INSERT)を行
	 * @param emp           社員情報
	 * @return              成否
	 * @throws Exception
	 */

	public boolean insert(EmpDto empDto)throws Exception{
		return addDao.insert(empDto);
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
