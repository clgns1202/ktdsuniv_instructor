package com.ktdsuniv.instructor.user.service.impl;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
}
