package com.ktdsuniv.instructor.grade.dao;

import java.util.List;

import grades.schema.GradesSchema;
import user.schema.UsersSchema;

public interface GradeDao {

	public List<GradesSchema> getGradeListByLecture(String lectureName);

	public int addNewGrade(GradesSchema grades);

	public List<UsersSchema> getAllUserByLecture(String lectureId);

}
