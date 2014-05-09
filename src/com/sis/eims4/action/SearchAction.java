package com.sis.eims4.action;

import java.io.OutputStream;

import com.sis.eims4.entity.Condition;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.Pagination;
import com.sis.eims4.service.SearchService;
import com.sis.eims4.service.impl.SearchSerImpl;
import com.sis.eims4.util.CommonUtil;
import com.sis.eims4.util.Constants;
/**
 * ユーザ情報の検索検索を行う
 * @author test01
 *
 */
public class SearchAction extends BaseAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SearchService service = new SearchSerImpl();
	private Dept dept;
	/**
	 * 初期表示
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String access()throws Exception {
		condition = null;
		return SUCCESS;
	}
	/**
	 * リセットボタン押下,画面項目の内容を初期进入表示時の状態に戻す
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String reset()throws Exception {
		condition = null;
		session.remove(Constants.getSesCondition());
		return SUCCESS;
	}
	/**
	 * 他の画面から戻る
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String reappear()throws Exception {
		Pagination pag = condition.getPagination();
		if(pag!=null){
			int count = service.countResult(condition);
			pag.setCountItem(count);
			pag.setMaxPage(count%pag.getPageSize()==0?count/pag.getPageSize():count/pag.getPageSize()+1);
			condition.setPagination(pag);
			session.put(Constants.getSesCondition(), condition);
			empList = service.findEmps(condition);
			if(empList.size()==0){
				empList = null;
			}
		}
		return SUCCESS;
	}
	/**
	 * 検索ボタン押下,検索条件保存する
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String search()throws Exception {
		if(condition==null){
			condition = new Condition();
		}
		int count = service.countResult(condition);
		Pagination pag = new Pagination();
		//設置総本数
		pag.setCountItem(count);
		//設置最大のページ
		pag.setMaxPage(count%pag.getPageSize()==0?count/pag.getPageSize():count/pag.getPageSize()+1);
		//設置ページ
		condition.setPagination(pag);
		if(count == 0){
			empList = null;
		}else{
			empList = service.findEmps(condition);
		}
		//設置検索条件
		session.put(Constants.getSesCondition(), condition);
		return SUCCESS;
	}
	/**
	 * ページをめくる（前へ、次へリンク押下,検索条件保持検索後の状態の条件,画面項目の内容保持検索後の状態）
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String turnPage()throws Exception {
		condition = (Condition)session.get(Constants.getSesCondition());
		Pagination pag = condition.getPagination();
		pag.setPage(Integer.parseInt(request.getParameter("page")));
		condition.setPagination(pag);
		session.put(Constants.getSesCondition(), condition);
		empList = service.findEmps(condition);
		return SUCCESS;
	}
	/**
	 * ajax获取部门地址
	 * @return
	 * @throws Exception
	 */
	public String local()throws Exception {
		dept = service.findDeptById(dept.getDeptno());
		if(dept==null){
			dept = new Dept();
		}
		return SUCCESS;
	}
	/**
	 * ダウンロード
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String excelDownLoad()throws Exception {
		empList = service.findEmps((Condition)session.get(Constants.getSesCondition()));
		OutputStream outputStream = response.getOutputStream();
		response.reset();
		response.setCharacterEncoding("shift_jis");
		response.addHeader("Content-Disposition", "attachment; filename=out.xls");
		response.setContentType("application/octet-stream");
		//样板目录
		String applicationPath = request.getServletContext().getRealPath(request.getRequestURI());
		applicationPath = applicationPath.substring(0, applicationPath.indexOf("eims2"))+"eims2\\resource\\template.xls";
		service.printToExcelFile(empList,outputStream,applicationPath);
		outputStream.flush();
		outputStream.close();
		return SUCCESS;
	}
	/**
	 * ダウンロード
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String csvDownLoad()throws Exception {
		empList = service.findEmps((Condition)session.get(Constants.getSesCondition()));
		OutputStream outputStream = response.getOutputStream();
		response.reset();
		response.addHeader("Content-Disposition", "attachment; filename=out.csv");
		response.setContentType("application/octet-stream");
		service.printToCsvFile(empList,outputStream);
		outputStream.flush();
		outputStream.close();
		return SUCCESS;
	}
	/**
	 * prepare是在validate拦截器之前执行，实现prepareble接口
	 */
	public void prepare() throws Exception {
		deptList = service.findDepts();                   //部門情報
	}
	/**
	 * 入力チェックを行う
	 */
	public void validateSearch()throws Exception{
		check(condition);
		session.put(Constants.getSesCondition(), condition);
	}
	/**
	 * 入力チェックを行う
	 */
	public void validateReappear()throws Exception{
		condition = (Condition)session.get(Constants.getSesCondition());
		if(condition==null){
			condition = new Condition();
		}else{
			check(condition);
		}
	}
	/**
	 * 入力チェックを行う
	 * @param condition 検索条件
	 */
	public void check(Condition condition){
		String salFrom = condition.getSalFrom();          //給料範囲(FROM)
		String salTo = condition.getSalTo();              //給料範囲(TO)
		//給料範囲(FROM)チェックを行う
		if((!CommonUtil.isEmpty(salFrom)&&!CommonUtil.isHalfNum(salFrom))||
				(salFrom.length()>0&&salFrom.trim().equals(""))){
			//addActionError(getText("E00019",new String[]{"給料範囲(FROM)"}));
			addFieldError("salFromError",getText("E00019",new String[]{"給料範囲(FROM)"}));
		}
		//給料範囲(TO)チェックを行う
		if((!CommonUtil.isEmpty(salTo)&&!CommonUtil.isHalfNum(salTo))||
				(salTo.length()>0&&salTo.trim().equals(""))){
			addFieldError("salToError",getText("E00019",new String[]{"給料範囲(TO)"}));
		}
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
}
