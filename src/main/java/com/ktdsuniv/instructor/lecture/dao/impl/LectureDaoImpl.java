package com.ktdsuniv.instructor.lecture.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.instructor.lecture.dao.LectureDao;

import common.support.mongo.MongoTemplateSupport;
import grades.schema.TestsSchema;
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
	
	@Override
	public int inputScoreByLectureId(List<UsersSchema> usersSchemas) {

		Criteria criteria = null;
		Query query = null;
		
		for (UsersSchema usersSchema : usersSchemas) {
			criteria = new Criteria("userId");
			criteria.is(usersSchema.getUserId());
			
			query = new Query(criteria);
			
			Update update = new Update();
			update.push("tests", usersSchema.getTests().get(0));
			
			getMongo().updateFirst(query, update, UsersSchema.class, "users");
		}
		
		/*for (UsersSchema usersSchema : usersSchemas) {
			criteria = new Criteria("id");
			criteria.is(usersSchema.getTests().get(0).getLectureId());
			query = new Query(criteria);
			LecturesSchema lecuture = getMongo().findOne(query, LecturesSchema.class);
			
			
		}*/
		
		
		return 1;
	}
	
}
