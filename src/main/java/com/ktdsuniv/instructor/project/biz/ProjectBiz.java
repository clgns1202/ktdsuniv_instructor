package com.ktdsuniv.instructor.project.biz;

import java.util.List;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import project.schema.TeamsSchema;
import user.schema.UsersSchema;

public interface ProjectBiz {

	public boolean addTeam(TeamsSchema team);

	public PageListVO getAllTeams(SearchVO search);

	public List<UsersSchema> getUsersByLectureId(String lectureId);

	public boolean modifyTeam(TeamsSchema team);

}
