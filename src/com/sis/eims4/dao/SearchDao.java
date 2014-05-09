package com.sis.eims4.dao;

import java.util.List;

import com.sis.eims4.entity.Condition;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;
/**
 * 検索
 * @author test01
 *
 */
public interface SearchDao {
	/**
	 * 検索部門情報
	 * @return               部門情報
	 * @throws Exception
	 */
	public List<Dept> findDepts()throws Exception;
	/**
	 * 検索部門情報
	 * @param deptno         部門ID
	 * @return               部門情報
	 * @throws Exception
	 */
	public  Dept findDeptById(int deptno) throws Exception;
	/**
	 * 検索社員情報,所属部門コンボには全部門を表示、ソート順は部門ID昇順
	 * @return               社員情報
	 * @throws Exception
	 */
	public List<EmpDto> findEmps(Condition condition)throws Exception;
	/**
	 * 検索社員情報全件数
	 * @param ename          氏名
	 * @param deptno         部門ID
	 * @param hiredate       雇用日付
	 * @param salFrom        給料範囲(FROM)
	 * @param salTo          給料範囲(TO)
	 * @param hasComm        賞与有り
	 * @return               社員情報全件数
	 * @throws Exception
	 */
	public int countResult(Condition condition) throws Exception;
	/**
	 * 検索社員情報
	 * @param empno         社員ID
	 * @return              社員情報
	 * @throws Exception
	 */
	public EmpDto findEmpById(int empno) throws Exception;
	/**
	 * 検索社員上司情報
	 * @return              社員上司情報
	 * @throws Exception
	 */
	public List<Manager> findMgrs() throws Exception;

	/**
	 * 検索上司情報
	 * @param empno         上司ID
	 * @return              上司情報
	 * @throws Exception
	 */
	public Manager findMgrById(int mgrno) throws Exception;
}
