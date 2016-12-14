package com.ktdsuniv.instructor.user.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.service.UserService;

import common.constants.Session;
import lecture.schema.LecturesSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserServiceImpl implements UserService {

	private UserBiz userBiz;
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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

	@Override
	public List<LecturesSchema> getInstructorLecture(HttpSession session) {
		InstructorsSchema instructor = (InstructorsSchema) session.getAttribute(Session.INSTRUCTOR);
		return userBiz.getInstructorLecture(instructor);
	}
	
	
}
