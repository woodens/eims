package com.sis.eims4.action;

import com.sis.eims4.service.AddService;
import com.sis.eims4.service.impl.AddSerImpl;
import com.sis.eims4.util.CommonUtil;
import com.sis.eims4.util.Constants;
/**
 * 社員新規
 * @author test01
 *
 */
public class AddAction extends BaseAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private AddService service = new AddSerImpl();
	/**
	 * 初期表示
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String access()throws Exception{
		return SUCCESS;
	}
	/**
	 * リセット
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String reset()throws Exception{
		empDto = null;
		return SUCCESS;
	}
	/**
	 * 登録ボタン押下,正常の場合、社員新規確認画面へ遷移する
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String addConfirm()throws Exception {
		return LOGIN;
	}
	/**
	 * prepare是在validate校验之前执行，实现prepareble接口
	 */
	public void prepare() throws Exception {
		deptList = service.findDepts();          //部門情報
		mgrList = service.findMgrs();            //上司情報
	}
	/**
	 * 入力チェックを行う
	 * @return                    エラー情報
	 */
	public void validateAddConfirm()throws Exception{
		//氏名チェックを行う
		String ename = empDto.getEname();
		if(CommonUtil.isEmpty(ename)){
			addFieldError("enameError",getText("E00006",new String[]{"氏名"}));
		}else if(ename.getBytes().length>20){
			addFieldError("enameError",getText("E00007",new String[]{"氏名","20"}));
		}
		//仕事チェックを行う
		String job = empDto.getJob();
		if(!CommonUtil.isEmpty(job)&&job.getBytes().length>50){
			addFieldError("jobError",getText("E00007",new String[]{"仕事","50"}));
		}
		//給料チェックを行う
		String sal = empDto.getSal();
		if((!CommonUtil.isEmpty(sal)&&!CommonUtil.isHalfNum(sal))||
				(sal.length()>0&&sal.replace("　", "").trim().equals(""))){
			addFieldError("salError",getText("E00001",new String[]{"給料"}));
		}
		//賞与チェックを行う
		String comm = empDto.getComm();
		if((!CommonUtil.isEmpty(comm)&&!CommonUtil.isHalfNum(comm))||
				(comm.length()>0&&comm.replace("　", "").trim().equals(""))){
			addFieldError("commError",getText("E00001",new String[]{"賞与"}));
		}
		//雇用日付チェックを行う
		String hiredate = empDto.getHiredate();
		if((!CommonUtil.isEmpty(hiredate)&&!CommonUtil.isValidDate(hiredate))||
				(hiredate.length()>0&&hiredate.replace("　", "").trim().equals(""))){
			addFieldError("hiredateError",getText("E00008",new String[]{"雇用日付"}));
		}
		//メモチェックを行う
		String memo = empDto.getMemo();
		if(!CommonUtil.isEmpty(memo)&&memo.getBytes().length>4000){
			addFieldError("memoError",getText("E00007",new String[]{"メモ","4000"}));
		}
		//設置操作状況
		session.put("operateFlag",Constants.getAddFlag());
		if(hasErrors()){
		//設置エラー状況
			session.put("errorFlag",Constants.getInputErrorFlag());
		}
	}

}
