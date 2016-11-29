package com.ktdsuniv.instructor.room.biz.impl;

import com.ktdsuniv.instructor.room.biz.RoomBiz;
import com.ktdsuniv.instructor.room.dao.RoomDao;

public class RoomBizImpl implements RoomBiz {

	private RoomDao roomDao;

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

}
