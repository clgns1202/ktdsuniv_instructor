package com.ktdsuniv.instructor.lecture.service;

import java.util.List;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface LectureService {
	public LecturesSchema getDetailLecture(String lectureId);
	public LecturesSchema getDetailLectureUsers(String lectureId);
	
}
