package com.ktdsuniv.instructor.room.biz.impl;

import com.ktdsuniv.instructor.room.biz.SeatBiz;
import com.ktdsuniv.instructor.room.dao.SeatDao;

public class SeatBizImpl implements SeatBiz {

	private SeatDao seatDao;
	
	public void setSeatDao(SeatDao seatDao) {
		this.seatDao = seatDao;
	}
	
}
