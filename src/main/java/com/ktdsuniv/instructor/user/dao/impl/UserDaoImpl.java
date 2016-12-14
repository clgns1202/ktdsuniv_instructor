package com.ktdsuniv.instructor.user.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.instructor.user.dao.UserDao;

import common.support.mongo.MongoTemplateSupport;
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
		logger.debug("솔트트으으으으으으으으"+instructors);
		return instructors.getUser().getUserSalt();
	}

	@Override
	public InstructorsSchema instructorSignIn(UsersSchema user) {
		Criteria criteria = new Criteria("userId");
		criteria.is(user.getUserId());
		criteria = criteria.and("userPassword");
		criteria.is(user.getUserPassword());
		
		Query query = new Query(criteria);
		
		return getMongo().findOne(query, InstructorsSchema.class, "instructors");
	}

	
	
}
