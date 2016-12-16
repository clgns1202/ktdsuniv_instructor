package com.ktdsuniv.instructor.lecture.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniv.instructor.lecture.biz.LectureBiz;
import com.ktdsuniv.instructor.lecture.service.LectureService;

import common.mongo.biz.CommonBiz;
import grades.schema.TestsSchema;
import user.schema.UsersSchema;

public class LectureServiceImpl implements LectureService {

	private LectureBiz lectureBiz;
	private CommonBiz commonBiz;
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	
	public void setLectureBiz(LectureBiz lectureBiz) {
		this.lectureBiz = lectureBiz;
	}

	@Override
	public List<UsersSchema> getUserByLectureId(String lectureId) {
		return lectureBiz.getUserByLectureId(lectureId);
	}
	
	@Override
	public boolean inputScoreByLectureId(List<UsersSchema> usersSchemas) {
		return lectureBiz.inputScoreByLectureId(usersSchemas);
	}
	
}
