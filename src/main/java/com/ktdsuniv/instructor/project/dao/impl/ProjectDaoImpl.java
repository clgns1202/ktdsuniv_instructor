package com.ktdsuniv.instructor.project.dao.impl;

import java.util.List;

import com.ktdsuniv.instructor.project.dao.ProjectDao;

import common.support.mongo.MongoTemplateSupport;
import project.schema.TeamsSchema;
import user.schema.UsersSchema;

public class ProjectDaoImpl extends MongoTemplateSupport implements ProjectDao {

	@Override
	public int addTeam(TeamsSchema team) {
		getMongo().insert(team);
		return 1;
	}

	@Override
	public List<UsersSchema> getUsersByLectureId(String lectureId) {
		
		return null;
	}

	@Override
	public int modifyTeam(TeamsSchema team) {
		return 1;
	}

}
