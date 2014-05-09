package com.sis.eims4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.sis.eims4.dao.SearchDao;
import com.sis.eims4.entity.Condition;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;
import com.sis.eims4.util.CommonUtil;
import com.sis.eims4.util.DBUtil;
import com.sis.eims4.util.HibernateUtil;
/**
 * 検索
 * @author test01
 *
 */
public class SearchDaoImpl implements SearchDao{

	/**
	 * 検索部門情報
	 * @return               部門情報
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public  List<Dept> findDepts() throws Exception {
		List<Dept> depts = new ArrayList<Dept>();
		Session session = HibernateUtil.openSession();
		depts = (List<Dept>) session.createCriteria(Dept.class).addOrder(Order.asc("deptno")).list();
		//depts = session.createQuery("from Dept").list();
		//System.out.println("执行次数");
		//session.close();
		HibernateUtil.closeSession();
		return depts;
	}

	/**
	 * 検索部門情報
	 * @param deptno         部門ID
	 * @return               部門情報
	 * @throws Exception
	 */
	public  Dept findDeptById(int deptno) throws Exception {
		Dept dept = new Dept();
		Session session = HibernateUtil.openSession();
		String sql = "from Dept d where d.deptno=?";
		Query query = session.createQuery(sql);
		query.setParameter(0, deptno);
		dept = (Dept)query.uniqueResult();
		HibernateUtil.closeSession();
		return dept;
	}
	 /**
	 * 検索社員情報,所属部門コンボには全部門を表示、ソート順は部門ID昇順
	 * @return               社員情報
	 * @throws Exception
	 */

	public List<EmpDto> findEmps(Condition condition)throws Exception{
		List<EmpDto> empList = new ArrayList<EmpDto>();
		Connection conn = DBUtil.getConnection();
		StringBuffer sql =new StringBuffer("select e1.EMPNO" +
										          ",e1.ENAME" +
											      ",e1.JOB" +
											      ",e1.HIREDATE" +
										          ",IFNULL(e1.SAL,0)"+
											      ",IFNULL(e1.SAL,0)*12+IFNULL(e1.COMM,0)*2 ANNUALSAL" +
											      ",e2.ENAME MNAME" +
											      ",d.DNAME " +
										    "  from WEB_EMP e1" +
									        "  left join WEB_EMP e2 on e1.MGR=e2.EMPNO" +
									        "  left join WEB_DEPT d on e1.DEPTNO=d.DEPTNO" +
						                    "  where 1=1 ");
		sql = appendSQL(sql, condition.getEname(), condition.getDeptno(), condition.getHiredate(), condition.getSalFrom(), condition.getSalTo(), condition.isHasComm());
		sql = sql.append(
				 " order by e1.DEPTNO,ANNUALSAL DESC "
				 +"LIMIT "+(condition.getPagination().getStartRow()-1)
				 +" ,"+(condition.getPagination().getEndRow()-condition.getPagination().getStartRow()+1)
				);
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			EmpDto item = new EmpDto();
			item.setEmpno(rs.getInt("EMPNO"));
			item.setEname(rs.getString("ENAME"));
			item.setJob(rs.getString("JOB"));
			item.setMgrname(rs.getString("MNAME"));
			double annualSal = rs.getDouble("ANNUALSAL");
			if(annualSal==0){
				item.setAnnualSal(null);
			}else{
				item.setAnnualSal(Double.toString(annualSal));
			}
			item.setDname(rs.getString("DNAME"));
			empList.add(item);
		}
		DBUtil.close(conn, ps, rs);
		return empList;
	}
	/**
	 * 検索社員情報
	 * @param empno         社員ID
	 * @return              社員情報
	 * @throws Exception
	 */

	public EmpDto findEmpById(int empno) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select*from WEB_EMP where EMPNO = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, empno);
		ResultSet rs = ps.executeQuery();
		EmpDto empDto = new EmpDto();
		if(rs.next()){
			empDto.setEmpno(empno);
			empDto.setEname(rs.getString("ename"));
			empDto.setJob(rs.getString("job"));
			empDto.setMgrno(rs.getInt("mgr"));
			if(rs.getDate("hiredate")!=null){
				empDto.setHiredate(CommonUtil.toString(rs.getDate("hiredate")));
			}else{
				empDto.setHiredate("");
			}
			if(rs.getDouble("sal")!=0){
				empDto.setSal(Double.toString(rs.getDouble("sal")));
			}else{
				empDto.setSal("");
			}
			if(rs.getDouble("comm")!=0){
				empDto.setComm(Double.toString(rs.getDouble("comm")));
			}else{
				empDto.setComm("");
			}
			empDto.setDeptno(rs.getInt("DEPTNO"));
			empDto.setMemo(rs.getString("MEMO"));
		}else{
			empDto=null;
		}
		DBUtil.close(conn, ps, rs);
		return empDto;
	}

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

	public int countResult(Condition condition) throws Exception {
		int count = 0;
		Connection conn = DBUtil.getConnection();
		StringBuffer sql =new StringBuffer("select count(*) count" +
											" from("+
														    "select e1.EMPNO" +
														          ",e1.ENAME" +
															      ",e1.JOB" +
															      ",IFNULL(e1.SAL,0) SAL"+
															      ",IFNULL(e1.SAL,0)*12+IFNULL(e1.COMM,0)*2 ANNUALSAL" +
															      ",e2.ENAME MNAME" +
															      ",d.DNAME " +
														    "  from WEB_EMP e1" +
													        "  left join WEB_EMP e2 on e1.MGR=e2.EMPNO" +
													        "  left join WEB_DEPT d on e1.DEPTNO=d.DEPTNO" +
										                    "  where 1=1 ");
		String ename = condition.getEname();
		if(!CommonUtil.isEmpty(ename)){
			ename = ename.replace("%", "\\%");
			ename = ename.replace("％", "\\％");
			ename = ename.replace("＿", "\\＿");
			ename = ename.replace("_", "\\_");
			sql = sql.append("and e1.ENAME like '%"+ename+"%' escape '\\' ");
		}

		int deptno = condition.getDeptno();
		if(deptno!=0){
			sql = sql.append("and e1.DEPTNO="+deptno+" ");
		}

		String hiredate = condition.getHiredate();
		if(!CommonUtil.isEmpty(hiredate)){
			if(hiredate.equals("before")){
				sql = sql.append("and e1.HIREDATE<'2000/01/01' ");
			}
			if(hiredate.equals("after")){
				sql = sql.append("and e1.HIREDATE>='2000/01/01' ");
			}
			if(hiredate.equals("empty")){
				sql = sql.append("and e1.HIREDATE is null ");
			}
		}
		String salFrom = condition.getSalFrom();
		if(!CommonUtil.isEmpty(salFrom)){
			sql = sql.append("and IFNULL(e1.SAL,0)>="+Double.parseDouble(salFrom)+" ");
		}
		String salTo = condition.getSalTo();
		if(!CommonUtil.isEmpty(salTo)){
			sql = sql.append("and IFNULL(e1.SAL,0)<="+Double.parseDouble(salTo)+" ");
		}
		boolean hasComm = condition.isHasComm();
		if(hasComm){
			sql = sql.append("and e1.COMM is not null ");
		}
		sql = sql.append(
				 " order by e1.DEPTNO,ANNUALSAL DESC) AS TAB "
				);
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getInt("count");
		}
		DBUtil.close(conn, ps, rs);
		return count;
	}

	/**
	 * 検索社員上司情報
	 * @return              社員上司情報
	 * @throws Exception
	 */

	public List<Manager> findMgrs() throws Exception {
		List<Manager> mgrs = new ArrayList<Manager>();
		Connection conn = DBUtil.getConnection();
		String sql = "select  ENAME MNAME"+
				            ",EMPNO MGRNO " +
				       "from  WEB_EMP " +
				       "order by  EMPNO";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Manager mgr = new Manager();
			mgr.setMgrno(rs.getInt("MGRNO"));
			mgr.setMname(rs.getString("MNAME"));
			mgrs.add(mgr);
		}
		DBUtil.close(conn, ps, rs);
		return mgrs;
	}

	/**
	 * 拼接sql语句
	 * @param sql            sql语句
	 * @param ename          氏名
	 * @param deptno         部門ID
	 * @param hiredate       雇用日付
	 * @param salFrom        給料範囲(FROM)
	 * @param salTo          給料範囲(TO)
	 * @param hasComm        賞与有り
	 * @return
	 * @throws Exception
	 */
	public StringBuffer appendSQL(StringBuffer sql,String ename, int deptno, String hiredate,
			String salFrom, String salTo, boolean hasComm)throws Exception{
		if(!CommonUtil.isEmpty(ename)){
			ename = ename.replace("%", "\\%");
			ename = ename.replace("％", "\\％");
			ename = ename.replace("＿", "\\＿");
			ename = ename.replace("_", "\\_");
			sql = sql.append("and e1.ENAME like '%"+ename+"%' escape '\\' ");
		}
		if(deptno!=0){
			sql = sql.append("and e1.DEPTNO = "+deptno+" ");
		}
		if(!CommonUtil.isEmpty(hiredate)){
			if(hiredate.equals("before")){
				sql = sql.append("and e1.HIREDATE < '2000/01/01' ");
			}
			if(hiredate.equals("after")){
				sql = sql.append("and e1.HIREDATE >= '2000/01/01' ");
			}
			if(hiredate.equals("empty")){
				sql = sql.append("and e1.HIREDATE is null ");
			}
		}
		if(!CommonUtil.isEmpty(salFrom)){
			sql = sql.append("and IFNULL(e1.SAL,0) >= "+Double.parseDouble(salFrom)+" ");
		}
		if(!CommonUtil.isEmpty(salTo)){
			sql = sql.append("and IFNULL(e1.SAL,0) <= "+Double.parseDouble(salTo)+" ");
		}
		if(hasComm){
			sql = sql.append("and e1.COMM is not null ");
		}
		return sql;
	}


	public Manager findMgrById(int mgrno) throws Exception {
		Manager mgr = new Manager();
		Connection conn = DBUtil.getConnection();
		String sql = "select*from WEB_EMP where EMPNO = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, mgrno);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			mgr.setMgrno(mgrno);
			mgr.setMname(rs.getString("ename"));
		}else{
			mgr = null;
		}
		DBUtil.close(conn, ps, rs);
		return mgr;
	}
}
