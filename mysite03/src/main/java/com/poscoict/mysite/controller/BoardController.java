package com.poscoict.mysite.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscoict.mysite.service.BoardService;
import com.poscoict.mysite.vo.BoardVo;



@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<BoardVo> list = boardService.getMessageList(null);
		model.addAttribute("list", list);
		return "board/list";
	}

	//글쓰기
	@RequestMapping(value="/writeform", method=RequestMethod.GET) //먼저 form으로 가야함
	public String writeform() {
		return "board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST) //가서 write수행
	public String add(BoardVo vo) {
		boardService.addContents(vo);
		return "redirect:/board";

	}
	
	//글 수정
	@RequestMapping(value="/modifyform/{no}", method=RequestMethod.GET) //먼저 form으로 가야함
	public String modifyform(@PathVariable("no") Long no, Model model) {
		BoardVo boardVo = boardService.getContents(no); //수정해야할 제목, 글 받아와야함
		model.addAttribute("vo", boardVo);
		return "board/modify";
	} 
	
	@RequestMapping(value="/modify", method=RequestMethod.POST) //가서 modify 수행
	public String modify(BoardVo vo) {
		boardService.updateContents(vo);
		return "redirect:/board";

	}
	
	//글 보기
	@RequestMapping(value="/view/{no}", method=RequestMethod.GET)
	public String view(@PathVariable("no") Long no, Model model) {
		BoardVo boardVo = boardService.getContents(no);
		model.addAttribute("boardVo", boardVo);
		
		return "board/view";
	}

	//글 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(BoardVo vo) {
		boardService.deleteContents(vo);
	//	model.addAttribute("no", no);
		return "redirect:/board";
	}

}