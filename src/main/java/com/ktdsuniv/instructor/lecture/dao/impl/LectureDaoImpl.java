package com.ktdsuniv.instructor.lecture.dao.impl;

import java.util.ArrayList;
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
		
		inputScoreToLecture(usersSchemas);
		
		return 1;
	}
	
	@Override
	public int inputScoreToLecture(List<UsersSchema> usersSchemas) {
		Criteria criteria = null;
		Query query = null;
		List<UsersSchema> users = new ArrayList<UsersSchema>();
		for (UsersSchema usersSchema : usersSchemas) {
			criteria = new Criteria("userId");
			criteria.is(usersSchema.getUserId());
			
			query = new Query(criteria);
			
			UsersSchema user = getMongo().findOne(query, UsersSchema.class, "users");
			users.add(user);
		}
		String lectureId = usersSchemas.get(0).getTests().get(0).getLectureId();
		criteria = new Criteria("id");
		criteria.is(lectureId);
		query = new Query(criteria);
		LecturesSchema lecture = getMongo().findOne(query, LecturesSchema.class, "lectures");
		lecture.setUser(users);
		
		getMongo().save(lecture);
		return 1;
	}
	
}
