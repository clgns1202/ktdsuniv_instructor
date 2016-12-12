package com.ktdsuniv.instructor.lecture.service.impl;

import java.util.List;

import com.ktdsuniv.instructor.lecture.biz.LectureBiz;
import com.ktdsuniv.instructor.lecture.service.LectureService;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class LectureServiceImpl implements LectureService {

	private LectureBiz lectureBiz;
	
	public void setLectureBiz(LectureBiz lectureBiz) {
		this.lectureBiz = lectureBiz;
	}

	@Override
	public List<UsersSchema> getUserByLectureId(String lectureId) {
		
		
		return lectureBiz.getUserByLectureId(lectureId);
	}
	
}
