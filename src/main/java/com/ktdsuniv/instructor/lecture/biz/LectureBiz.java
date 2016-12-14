package com.ktdsuniv.instructor.lecture.biz;

import java.util.List;

import user.schema.UsersSchema;

public interface LectureBiz {

	List<UsersSchema> getUserByLectureId(String lectureId);

}
