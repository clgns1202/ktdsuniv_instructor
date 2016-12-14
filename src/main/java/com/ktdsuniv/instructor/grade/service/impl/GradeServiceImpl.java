package com.ktdsuniv.instructor.grade.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniv.instructor.grade.biz.GradeBiz;
import com.ktdsuniv.instructor.grade.service.GradeService;

import common.mongo.biz.CommonBiz;
import grades.schema.GradesSchema;
import grades.schema.Scores;
import grades.schema.Tests;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class GradeServiceImpl implements GradeService {

	private GradeBiz gradeBiz;
	private CommonBiz commonBiz;
	private Logger logger = LoggerFactory.getLogger(GradeServiceImpl.class);
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	
	public void setGradeBiz(GradeBiz gradeBiz) {
		this.gradeBiz = gradeBiz;
	}
	
	@Override
	public List<GradesSchema> getGradeListByLecture(String lectureName) {
		
		return gradeBiz.getGradeListByLecture(lectureName);
	}
	
	@Override
	public boolean addNewGrade(Tests test, String userId, String lectureId) {
		
		Scores score = new Scores();
		GradesSchema grades = new GradesSchema();
		
		UsersSchema user = commonBiz.getUserById(userId);
		LecturesSchema lecture = commonBiz.getMongoById("id", lectureId, LecturesSchema.class);

		List<Tests> testList = new ArrayList<Tests>();
		List<Scores> scoreList = new ArrayList<Scores>();
		
		testList.add(test);
		score.setUser(user);
		score.setTest(testList);
		
		scoreList.add(score);
		
		grades.setLecture(lecture);
		grades.setScore(scoreList);
		
		return gradeBiz.addNewGrade(grades);
	}
	
	@Override
	public List<UsersSchema> getAllUserByLecture(String lectureId) {
		return gradeBiz.getAllUserByLecture(lectureId);
	}
	
}
