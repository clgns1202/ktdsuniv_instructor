package com.ktdsuniv.instructor.user.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.user.dao.UserDao;

import common.support.mongo.MongoTemplateSupport;
import lecture.schema.LecturesSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserDaoImpl extends MongoTemplateSupport implements UserDao {

	
	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Override
	public String getSalt(UsersSchema user) {
		Criteria criteria = new Criteria("user.userId");
		criteria.is(user.getUserId());
		Query query = new Query(criteria);
		query.fields().include("user.userSalt");
		
		InstructorsSchema instructors = getMongo().findOne(query, InstructorsSchema.class, "instructors");
		logger.debug("솔트트으으으으으으으으"+instructors.getUser().getUserSalt());
		return instructors.getUser().getUserSalt();
	}

	@Override
	public InstructorsSchema instructorSignIn(UsersSchema user) {
		Criteria criteria = new Criteria("user.userId");
		criteria.is(user.getUserId());
		criteria = criteria.and("user.userPassword");
		criteria.is(user.getUserPassword());
		
		Query query = new Query(criteria);
		
		return getMongo().findOne(query, InstructorsSchema.class, "instructors");
	}

	@Override
	public List<LecturesSchema> getInstructorLecture(InstructorsSchema instructor) {
		
		logger.debug("강사이름" + instructor.getUser().getUserName());
		
		Criteria criteria = new Criteria("instructor.user.userName");
		criteria.is(instructor.getUser().getUserName());
		Query query = new Query(criteria);
		return getMongo().find(query, LecturesSchema.class, "lectures");
	}

	
	
}
