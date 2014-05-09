package com.sis.eims4.service.impl;

import java.util.List;

import com.sis.eims4.dao.AddDao;
import com.sis.eims4.dao.SearchDao;
import com.sis.eims4.dao.UpdateDao;
import com.sis.eims4.dao.impl.AddDaoImpl;
import com.sis.eims4.dao.impl.SearchDaoImpl;
import com.sis.eims4.dao.impl.UpdateDaoImpl;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;
import com.sis.eims4.service.ConfirmService;

public class ConfirmSerImpl implements ConfirmService{
	private SearchDao searchDao = new SearchDaoImpl();
	private UpdateDao updateDao = new UpdateDaoImpl();
	private AddDao addDao = new AddDaoImpl();
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
	 * 社員更新
	 * @param confirmForm   フォーム情報
	 * @return              成否
	 * @throws Exception
	 */
	public boolean update(EmpDto empDto) throws Exception {
		return updateDao.update(empDto);
	}


	/**
	 * 社員削除
	 * @param empno         社員ID
	 * @return              成否
	 * @throws Exception
	 */
	public boolean delete(int empno) throws Exception {
		return updateDao.delete(empno);
	}
	/**
	 * 登録（INSERT)を行
	 * @param EmpDto        社員情報
	 * @return              成否
	 * @throws Exception
	 */
	public boolean insert(EmpDto empDto)throws Exception{
		return addDao.insert(empDto);
	}
}
