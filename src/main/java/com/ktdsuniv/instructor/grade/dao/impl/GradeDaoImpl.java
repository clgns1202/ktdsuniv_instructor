package com.ktdsuniv.instructor.grade.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.grade.dao.GradeDao;

import common.support.mongo.MongoTemplateSupport;
import grades.schema.GradesSchema;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class GradeDaoImpl extends MongoTemplateSupport implements GradeDao {

	@Override
	public List<GradesSchema> getGradeListByLecture(String lectureName) {
		
		Criteria criteria = new Criteria("lecture.lectureName");
		criteria.is(lectureName);
		
		Query query = new Query(criteria);
		
		return getMongo().find(query, GradesSchema.class, "grades");
	}
	
	
	@Override
	public int addNewGrade(GradesSchema grades) {
		
		getMongo().save(grades, "grades");
		
		return 1;
	}
	
	@Override
	public List<UsersSchema> getAllUserByLecture(String lectureId) {
		Criteria criteria = new Criteria("_id");
		criteria.is(lectureId);
		
		Query query = new Query(criteria);
		
		LecturesSchema lectures = (LecturesSchema) getMongo().findOne(query, LecturesSchema.class, "lectures");
		
		return lectures.getUser();
	}
	
}
