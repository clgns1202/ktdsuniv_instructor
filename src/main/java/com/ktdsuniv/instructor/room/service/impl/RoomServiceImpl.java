package com.ktdsuniv.instructor.room.service.impl;

import com.ktdsuniv.instructor.room.biz.RoomBiz;
import com.ktdsuniv.instructor.room.service.RoomService;

public class RoomServiceImpl implements RoomService {

	private RoomBiz roomBiz;

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}
	
	
}
