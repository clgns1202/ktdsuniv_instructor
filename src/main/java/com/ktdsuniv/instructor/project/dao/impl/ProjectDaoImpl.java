package com.ktdsuniv.instructor.project.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
		getMongo().save(team);
		return 1;
	}

	@Override
	public int deleteTeam(String teamId) {
		Query query = new Query(new Criteria("_id").is(teamId));
		getMongo().remove(query, "teams");
		return 1;
	}

}
