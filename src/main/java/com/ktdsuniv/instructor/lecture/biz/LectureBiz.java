package com.ktdsuniv.instructor.lecture.biz;

import java.util.List;

import grades.schema.TestsSchema;
import user.schema.UsersSchema;

public interface LectureBiz {

	public List<UsersSchema> getUserByLectureId(String lectureId);

	public boolean inputScoreByLectureId(List<UsersSchema> usersSchemas);

}
