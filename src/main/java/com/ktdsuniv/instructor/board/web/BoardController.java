package com.ktdsuniv.instructor.board.web;

import org.springframework.stereotype.Controller;

import com.ktdsuniv.instructor.board.service.BoardService;

@Controller
public class BoardController {

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
}
