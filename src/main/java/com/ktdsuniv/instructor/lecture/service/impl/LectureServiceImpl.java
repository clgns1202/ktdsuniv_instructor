package com.ktdsuniv.instructor.lecture.service.impl;

import java.util.List;

import com.ktdsuniv.instructor.lecture.biz.LectureBiz;
import com.ktdsuniv.instructor.lecture.service.LectureService;

import common.mongo.biz.CommonBiz;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class LectureServiceImpl implements LectureService {

	private LectureBiz lectureBiz;
	private CommonBiz commonBiz;
	
	public void setLectureBiz(LectureBiz lectureBiz) {
		this.lectureBiz = lectureBiz;
	}
	
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}


	@Override
	public LecturesSchema getDetailLecture(String lectureId) {
		return commonBiz.getMongoById("_id", lectureId, LecturesSchema.class);
	}


	@Override
	public LecturesSchema getDetailLectureUsers(String lectureId) {
		return commonBiz.getMongoById("_id", lectureId, LecturesSchema.class);
	}



	
}
