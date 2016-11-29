package com.ktdsuniv.instructor.room.service.impl;

import com.ktdsuniv.instructor.room.biz.SeatBiz;
import com.ktdsuniv.instructor.room.service.SeatService;

public class SeatServiceImpl implements SeatService {

	private SeatBiz seatBiz;
	
	public void setSeatBiz(SeatBiz seatBiz) {
		this.seatBiz = seatBiz;
	}
	
}
