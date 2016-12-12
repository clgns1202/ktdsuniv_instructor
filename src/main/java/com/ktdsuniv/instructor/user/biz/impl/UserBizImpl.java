package com.ktdsuniv.instructor.user.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.instructor.user.biz.UserBiz;
import com.ktdsuniv.instructor.user.dao.UserDao;

import common.util.SHA256Util;
import lecture.schema.LecturesSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserBizImpl implements UserBiz {

	private UserDao userDao;

	private Logger logger = LoggerFactory.getLogger(UserBizImpl.class);
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public InstructorsSchema instructorSignIn(UsersSchema user) {
		String salt = userDao.getSalt(user);
		logger.debug("솔트 :"  + salt);
		user.setUserSalt(salt);
		
		String password = user.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		
		user.setUserPassword(password);
		
		return userDao.instructorSignIn(user);
	}

	@Override
	public List<LecturesSchema> getInstructorLecture(InstructorsSchema instructor) {
		return userDao.getInstructorLecture(instructor);
	}
	
}
