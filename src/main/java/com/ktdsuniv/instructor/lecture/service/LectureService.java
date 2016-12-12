package com.ktdsuniv.instructor.lecture.service;

import java.util.List;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public interface LectureService {

	public List<UsersSchema> getUserByLectureId(String lectureId);

}
