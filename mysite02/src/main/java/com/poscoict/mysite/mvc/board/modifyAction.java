package com.poscoict.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscoict.mysite.dao.BoardDao;
import com.poscoict.mysite.vo.BoardVo;

import com.poscoict.web.mvc.Action;
import com.poscoict.web.util.MvcUtil;

public class modifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*접근제어*/
//		HttpSession session=request.getSession();
		//BoardVo authUser=(BoardVo)session.getAttribute("authUser");
		System.out.println("modify");
		
		
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");//jsp에서 던진걸 자바로
		Long no=Long.parseLong(request.getParameter("no"));
//		int hit=Integer.parseInt(request.getParameter("hit"));
//		int groupNo=Integer.parseInt(request.getParameter("groupNo"));
//		int orderNo=Integer.parseInt(request.getParameter("orderNo"));
//		int Depth=Integer.parseInt(request.getParameter("depth"));
		//Long userNo=Long.parseLong(request.getParameter("userNo"));
		
		BoardVo vo=new BoardVo();

		vo.setTitle(title);
		vo.setContents(contents);  //받은걸 사용
		vo.setNo(no);
		//vo.setNo(no);
//		vo.setHit(hit);
//		vo.setGroupNo(groupNo);
//		vo.setOrderNo(orderNo);
//		vo.setDepth(Depth);
	//	vo.setUserNo(userNo);
		
		new BoardDao().update(vo);
//		request.setAttribute("vo", vo);
		
//		
		//redirct 안하면 계속 내가 이전에 요청했던 정보가 남아있음!! 
	//	session.setAttribute("authUser", vo); //수정된 vo가 반영
		//MvcUtil.forward("/board/list", request, response);
//		MvcUtil.redirect(request.getContextPath(), request, response);
		MvcUtil.redirect(request.getContextPath()+"/board" , request, response);// actionfactory에서 else는 list로

	}

}
