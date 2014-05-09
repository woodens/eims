package com.sis.eims4.service;

import java.io.OutputStream;
import java.util.List;

import com.sis.eims4.entity.Condition;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
/**
 * 検索
 * @author test01
 *
 */
public interface SearchService {
	/**
	 * ダウンロード
	 * @param empList        社員情報
	 * @param outputStream   出力ストリーム
	 * @return               result
	 * @throws Exception
	 */
	public boolean printToExcelFile(List<EmpDto> empList,OutputStream outputStream,String applicationPath)throws Exception;
	/**
	 * ダウンロード
	 * @param empList        社員情報
	 * @param outputStream   出力ストリーム
	 * @throws Exception
	 */
	public void printToCsvFile(List<EmpDto> empList,OutputStream outputStream)throws Exception;
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
	 * 検索社員情報
	 * @return               社員情報
	 * @throws Exception
	 */
	public List<EmpDto> findEmps(Condition condition)throws Exception;
	/**
	 * 検索社員情報全件数
	 * @return               社員情報総本数
	 * @throws Exception
	 */
	public int countResult(Condition condition) throws Exception;
}
