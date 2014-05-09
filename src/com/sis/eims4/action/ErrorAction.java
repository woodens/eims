package com.sis.eims4.action;

import com.sis.eims4.service.ConfirmService;
import com.sis.eims4.service.impl.ConfirmSerImpl;
import com.sis.eims4.util.Constants;
/**
 * システムエラー（オラクルエラー、セッションタイムアウト、認証エラー）を表示する
 * @author test01
 *
 */
public class ErrorAction extends BaseAction{
	private ConfirmService  service = new ConfirmSerImpl();
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 戻るボタンが押された場合は、遷移元へ遷移する;閉じるボタンが押された場合は、当画面を閉じる。
	 * 入力エラー場合、遷移元へ遷移する
	 * 整合エラー場合、社員情報一覧画面へ遷移する。
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String back()throws Exception {
		String forward = "";
		String errorFlag = (String)session.get("errorFlag");
		String flag = (String)session.get("operateFlag");
		//入力エラー場合、遷移元へ遷移する。
		if(errorFlag.equals(Constants.getInputErrorFlag())){
			//遷移元 社員新規画面 場合:社員情報一覧画面へ遷移する
			if(flag.equals(Constants.getAddFlag())){
				forward = "addBack";
			}
			//遷移元 社員編集画面 更新ボタン押下 場合:社員編集画面へ遷移する
			if(flag.equals(Constants.getUpdateFlag())){
				forward = "updateBack";
			}
			// 遷移元 社員編集画面 削除ボタン押下 場合:社員編集画面へ遷移する
			if(flag.equals(Constants.getDeleteFlag())){
				forward = "updateBack";
			}
		//整合エラー場合、社員情報一覧画面へ遷移する。
		}else if(errorFlag.equals(Constants.getConformErrorFlag())){
			forward = "searchBack";
		}
		return forward;
	}

	/**
	 * prepare是在validate拦截器之前执行，实现prepareble接口
	 */
	public void prepare() throws Exception {
		deptList = service.findDepts();                   //部門情報
		mgrList = service.findMgrs();                     //上司情報
	}

}
