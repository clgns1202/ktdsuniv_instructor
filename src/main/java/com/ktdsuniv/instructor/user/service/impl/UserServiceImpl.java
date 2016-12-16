package com.ktdsuniv.instructor.user.service.impl;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.service.UserService;

import common.constants.Session;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserServiceImpl implements UserService {

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	@Override
	public boolean instructorSignIn(UsersSchema user, HttpSession session) {
		InstructorsSchema signedInstructor = userBiz.instructorSignIn(user);
		if(signedInstructor != null) {
			session.setAttribute(Session.INSTRUCTOR, signedInstructor);
			return true;
		}
		return false;
	}
}
