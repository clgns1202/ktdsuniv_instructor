package com.ktdsuniv.instructor.lecture.service.impl;

import com.ktdsuniv.instructor.lecture.biz.LectureBiz;
import com.ktdsuniv.instructor.lecture.service.LectureService;

import lecture.schema.LecturesSchema;

public class LectureServiceImpl implements LectureService {

	private LectureBiz lectureBiz;
	
	public void setLectureBiz(LectureBiz lectureBiz) {
		this.lectureBiz = lectureBiz;
	}

	@Override
	public LecturesSchema getLectureById(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
