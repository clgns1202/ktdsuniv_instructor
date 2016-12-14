package com.ktdsuniv.instructor.grade.biz.impl;

import java.util.List;

import com.ktdsuniv.instructor.grade.biz.GradeBiz;
import com.ktdsuniv.instructor.grade.dao.GradeDao;

import grades.schema.GradesSchema;
import user.schema.UsersSchema;

public class GradeBizImpl implements GradeBiz {

	private GradeDao gradeDao;
	
	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}
	
	@Override
	public List<GradesSchema> getGradeListByLecture(String lectureName) {
		return gradeDao.getGradeListByLecture(lectureName);
	}
	
	@Override
	public boolean addNewGrade(GradesSchema grades) {
		return gradeDao.addNewGrade(grades)>0;
	}
	
	@Override
	public List<UsersSchema> getAllUserByLecture(String lectureId) {
		return gradeDao.getAllUserByLecture(lectureId);
	}
}
