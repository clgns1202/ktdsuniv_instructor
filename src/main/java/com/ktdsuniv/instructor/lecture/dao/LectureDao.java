package com.ktdsuniv.instructor.lecture.dao;

import java.util.List;

import grades.schema.TestsSchema;
import user.schema.UsersSchema;

public interface LectureDao {

	public List<UsersSchema> getUserByLectureId(String lectureId);

	public int inputScoreByLectureId(List<UsersSchema> usersSchemas);

	public int inputScoreToLecture(List<UsersSchema> usersSchemas);
}
