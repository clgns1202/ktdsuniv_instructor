package com.ktdsuniv.instructor.project.dao;

import java.util.List;

import project.schema.TeamsSchema;
import user.schema.UsersSchema;

public interface ProjectDao {

	public int addTeam(TeamsSchema team);

	public List<UsersSchema> getUsersByLectureId(String lectureId);

	public int modifyTeam(TeamsSchema team);

}
