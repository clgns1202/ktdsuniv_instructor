package com.ktdsuniv.instructor.grade.service;

import java.util.List;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import grades.schema.GradesSchema;
import grades.schema.Tests;
import user.schema.UsersSchema;

public interface GradeService {

	public List<GradesSchema> getGradeListByLecture(String lectureName);

	public boolean addNewGrade(Tests test, String userId, String lectureId);

	public List<UsersSchema> getAllUserByLecture(String lectureId);

}
