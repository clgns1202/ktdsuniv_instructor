package com.ktdsuniv.instructor.lecture.dao;

import java.util.List;

import user.schema.UsersSchema;

public interface LectureDao {

	public List<UsersSchema> getUserByLectureId(String lectureId);


}
