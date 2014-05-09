package com.sis.eims4.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 一般工具
 * @author test01
 *
 */
public class CommonUtil {
	/**
	 * チェックは空に
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		boolean chkResult = false;
		if (str == null||str.trim().equals("")) {
			chkResult = true;
		}else{
			str = str.replace("　","");
			if(str.trim().equals("")){
				chkResult = true;
			}
		}
		return chkResult;
	}

	/**
	 * チェックを半角数字
	 * @param str
	 * @return
	 */
	public static boolean isHalfNum(String str) {
		boolean chkResult = false;
		if (str.matches("^[0-9]{0,5}(\\.[0-9]{1,2})?$")) {
			chkResult = true;
		}
		return chkResult;
	}

	/**
	 *正確な日付かどうかをチェック
	 * @param str
	 * @return
	 */
	public static boolean isValidDate(String str) {
		boolean chkResult = true;
		try {
			if (!str.matches("^[0-9]{4}(/[0-9]{1,2}){2}$")) {
				chkResult = false;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			sdf.setLenient(false);
			sdf.parse(str);
		} catch (Exception e) {
			chkResult = false;
		}
		return chkResult;
	}

	/**
	 * 日時フォーマット変換 Date==>String
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String toString(Date date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date);
	}
	/**
	 * 日時フォーマット変換  String==>Date
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String str) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return new java.sql.Date(sdf.parse(str).getTime());
	}

	/**
	 * null=====>" "
	 * @param str
	 * @return
	 */
	public static String nvlString(String str){
		if(str==null){
			str = " ";
		}
		return str;
	}
//	/**
//	 * Emp==>EmpDto
//	 * @param date
//	 * @return
//	 * @throws ParseException
//	 */
//	public static EmpDto toEmpDto(Emp emp) throws ParseException{
//		EmpDto empDto = new EmpDto();
//		if(emp==null){
//			empDto = null;
//		}else{
//			empDto.setEmpno(emp.getEmpno());
//			empDto.setEname(emp.getEname());
//			empDto.setJob(emp.getJob());
//			if(emp.getHiredate()!=null){
//				empDto.setHiredate(toString(emp.getHiredate()));
//			}
//			empDto.setMgrno(emp.getMgrno());
//			empDto.setDeptno(emp.getDeptno());
//			if(emp.getSal()!=0){
//				empDto.setSal(Double.toString(emp.getSal()));
//			}else{
//				empDto.setSal("");
//			}
//			if(emp.getComm()!=0){
//				empDto.setComm(Double.toString(emp.getComm()));
//			}else{
//				empDto.setComm("");
//			}
//			empDto.setMemo(emp.getMemo());
//
//		}
//		return empDto;
//	}
//	/**
//	 * Emp==>EmpDto
//	 * @param date
//	 * @return
//	 * @throws ParseException
//	 */
//	public static Emp toEmp(EmpDto empDto) throws ParseException{
//		Emp emp = new Emp();
//		if(empDto==null){
//			emp = null;
//		}else{
//			emp.setEmpno(empDto.getEmpno());
//			emp.setEname(empDto.getEname());
//			emp.setJob(empDto.getJob());
//			if(empDto.getHiredate()!=null){
//				emp.setHiredate(parseDate(empDto.getHiredate()));
//			}
//			emp.setMgrno(empDto.getMgrno());
//			emp.setDeptno(empDto.getDeptno());
//			if(!isEmpty(empDto.getSal())){
//				emp.setSal(Double.parseDouble(empDto.getSal()));
//			}
//			if(!isEmpty(empDto.getComm())){
//				emp.setComm(Double.parseDouble(empDto.getComm()));
//			}
//			emp.setMemo(empDto.getMemo());
//
//		}
//		return emp;
//	}
}
