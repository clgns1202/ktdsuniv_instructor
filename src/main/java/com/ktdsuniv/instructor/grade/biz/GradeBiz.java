package com.ktdsuniv.instructor.grade.biz;

import java.util.List;

import grades.schema.GradesSchema;
import user.schema.UsersSchema;

public interface GradeBiz {

	public List<GradesSchema> getGradeListByLecture(String lectureName);

	public boolean addNewGrade(GradesSchema grades);

	public List<UsersSchema> getAllUserByLecture(String lectureId);

}
