package com.sis.eims4.action;

import com.sis.eims4.service.ConfirmService;
import com.sis.eims4.service.impl.ConfirmSerImpl;
import com.sis.eims4.util.Constants;

/**
 * 登録/編集/削除したユーザ情報の確認及び更新を行う
 * @author test01
 *
 */
public class ConfirmAction extends BaseAction{
	private ConfirmService  service = new ConfirmSerImpl();
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * キャンセルボタン押下,遷移元へ遷移する
	 * 遷移元 社員新規画面 場合:社員情報一覧画面へ遷移する
	 * 遷移元 社員編集画面 更新ボタン押下 場合:社員編集画面へ遷移する
	 * 遷移元 社員編集画面 削除ボタン押下 場合:社員編集画面へ遷移する
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String cancel()throws Exception {
		deptList = service.findDepts();                   //部門情報
		mgrList = service.findMgrs();                     //上司情報
		String forward = "";
		String flag = (String)session.get("operateFlag");
		//遷移元 社員新規画面 場合:社員情報一覧画面へ遷移する
		if(flag.equals(Constants.getAddFlag())){
			forward = "addBack";
		}
		//遷移元 社員編集画面 更新ボタン押下 場合:社員編集画面へ遷移する
		if(flag.equals(Constants.getUpdateFlag())){
			forward = "updateBack";
		}
		//遷移元 社員編集画面 削除ボタン押下 場合:社員編集画面へ遷移する
		if(flag.equals(Constants.getDeleteFlag())){
			forward = "updateBack";
		}
		return forward;
	}
	/**
	 * 動作ボタン押下
	 * @return                    遷移先対象
	 * @throws Exception
	 */
	public String confirm()throws Exception{
		String forward = "";
		boolean result = false;
		String flag = (String)session.get("operateFlag");
        //登録ボタンを表示する、登録（INSERT)を行う
		if(flag.equals(Constants.getAddFlag())){
			service.insert(empDto);
			forward = LOGIN;
		}
		//更新ボタンを表示する、更新（UPDATE)を行う
		if(flag.equals(Constants.getUpdateFlag())){
			result = service.update(empDto);
			if(result){
				forward = LOGIN;
			//更新しようとする対象データが存在しなかった場合、整合エラー画面へ遷移する。（エラーメッセージ：E00014)
			}else{
				addFieldError("updateError", getText("E00014"));
				session.put("errorFlag", Constants.getConformErrorFlag());
				forward = INPUT;
			}
		}
		//削除ボタンを表示する、削除（DELETE)を行う
		if(flag.equals(Constants.getDeleteFlag())){
			result = service.delete(empDto.getEmpno());
			if(result){
				forward = LOGIN;
			//削除しようとする対象データが存在しなかった場合、整合エラー画面へ遷移する。（エラーメッセージ：E00014)
			}else{
				session.put("errorFlag", Constants.getConformErrorFlag());
				addFieldError("deleteError",getText("E00014"));
				forward = INPUT;
			}
		}

		return forward;
	}
}
