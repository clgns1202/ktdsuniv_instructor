package com.ktdsuniv.instructor.board.biz.impl;

import com.ktdsuniv.instructor.board.biz.BoardBiz;
import com.ktdsuniv.instructor.board.dao.BoardDao;

public class BoardBizImpl implements BoardBiz {

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
}
