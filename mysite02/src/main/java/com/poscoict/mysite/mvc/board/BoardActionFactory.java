package com.poscoict.mysite.mvc.board;

import com.poscoict.web.mvc.Action;
import com.poscoict.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		
		if ("list".equals(actionName)) { // 글 목록
			action = new ListAction();
		} else if ("writeform".equals(actionName)) { // 글 쓰기 폼으로 이동
			action = new WriteFormAction();
		} else if ("write".equals(actionName)) { // 글 쓰기
			action = new WriteAction();
		}else if ("deleteform".equals(actionName)) { // deleteform.jsp로 보냄
			// System.out.println("delete");
			action = new DeleteFormAction();
		} else if ("delete".equals(actionName)) { // 삭제 구현
			action = new DeleteAction();
		} else if ("modify".equals(actionName)) { // 글 수정
			action = new modifyAction();
		} else if ("view".equals(actionName)) { // 글 내용 보기
			action = new viewAction();
		}else {
			action = new ListAction();
		}

		return action;

	}
}
