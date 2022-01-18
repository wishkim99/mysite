package com.poscoict.mysite.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscoict.mysite.dao.BoardDao;
import com.poscoict.mysite.vo.BoardVo;
import com.poscoict.web.mvc.Action;
import com.poscoict.web.util.MvcUtil;

public class viewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String title = request.getParameter("title");
//		String contents = request.getParameter("contents");
		Long no=Long.parseLong(request.getParameter("no"));

//		BoardVo vo = new BoardVo();
//		vo.setTitle(title);
//		vo.setContents(contents);
//		vo.setNo(no);
//
//		new BoardDao().insert(vo);
//		
//		MvcUtil.redirect("/mysite02/board", request, response);
		
//원래꺼
		BoardVo vo = new BoardDao().findByNo(no);
		request.setAttribute("vo", vo);
		
//findByNo	
//		Long no=Long.parseLong(request.getParameter("no"));
//		BoardVo vo=new BoardDao().findByNo(no);
//		
//		request.setAttribute("vo", vo);

		
		//BoardVo vo=(BoardVo)request.getAttribute("list");
		MvcUtil.forward("board/view", request, response);
		//MvcUtil.redirect("/mysite02/board", request, response);
		//MvcUtil.redirect(request.getContextPath() + "/board?a=view", request, response);
	}

}
