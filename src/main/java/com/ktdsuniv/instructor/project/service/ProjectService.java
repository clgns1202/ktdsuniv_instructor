package com.ktdsuniv.instructor.project.service;

import java.util.List;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import lecture.schema.LecturesSchema;
import project.schema.TeamsSchema;
import user.schema.UsersSchema;

public interface ProjectService {

	public UsersSchema getUserById(String id);

	public boolean addTeam(TeamsSchema team);

	public PageListVO getAllTeams(SearchVO search);

	public List<UsersSchema> getUsersByLectureId(String lectureId);
	
	public UsersSchema getTest(String userId);
	
	public PageListVO getListTest(SearchVO search);

	public LecturesSchema getLectureById(String lectureId);

	public TeamsSchema getTeamById(String teamId);

	public boolean modifyTeam(TeamsSchema team);

}
