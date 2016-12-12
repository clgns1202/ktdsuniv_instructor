package com.ktdsuniv.instructor.lecture.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.lecture.dao.LectureDao;

import common.support.mongo.MongoTemplateSupport;
import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

public class LectureDaoImpl extends MongoTemplateSupport implements LectureDao {

	private Logger logger = LoggerFactory.getLogger(LectureDaoImpl.class);
	
	@Override
	public List<UsersSchema> getUserByLectureId(String lectureId) {

		Criteria criteria = new Criteria("_id");
		criteria.is(lectureId);
		
		Query query = new Query(criteria);
		
		LecturesSchema lecture = (LecturesSchema) getMongo().findOne(query, LecturesSchema.class, "lectures");
		
		return lecture.getUser();
	}
	
}
