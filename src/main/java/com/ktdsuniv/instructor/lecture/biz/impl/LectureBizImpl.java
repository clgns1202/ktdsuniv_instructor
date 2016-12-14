package com.ktdsuniv.instructor.lecture.biz.impl;

import java.util.List;

import com.ktdsuniv.instructor.lecture.biz.LectureBiz;
import com.ktdsuniv.instructor.lecture.dao.LectureDao;

import user.schema.UsersSchema;

public class LectureBizImpl implements LectureBiz {

	private LectureDao lectureDao;
	
	public void setLectureDao(LectureDao lectureDao) {
		this.lectureDao = lectureDao;
	}
	
	@Override
	public List<UsersSchema> getUserByLectureId(String lectureId) {
		return lectureDao.getUserByLectureId(lectureId);
	}
	
}
