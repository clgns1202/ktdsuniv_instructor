package com.ktdsuniv.instructor.board.service.impl;

import com.ktdsuniv.instructor.board.biz.BoardBiz;
import com.ktdsuniv.instructor.board.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}
	
}
