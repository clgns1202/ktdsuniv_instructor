package com.ktdsuniv.instructor.project.biz.impl;

import java.util.List;

import com.ktdsuniv.instructor.lecture.dao.LectureDao;
import com.ktdsuniv.instructor.project.biz.ProjectBiz;
import com.ktdsuniv.instructor.project.dao.ProjectDao;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import lecture.schema.LecturesSchema;
import project.schema.TeamsSchema;
import user.schema.UsersSchema;

public class ProjectBizImpl implements ProjectBiz {

	private ProjectDao projectDao;
	
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public boolean addTeam(TeamsSchema team) {
		return projectDao.addTeam(team) > 0;
	}

	@Override
	public PageListVO getAllTeams(SearchVO search) {
		
		
		
		return null;
	}

	@Override
	public List<UsersSchema> getUsersByLectureId(String lectureId) {
		return projectDao.getUsersByLectureId(lectureId);
	}

	@Override
	public boolean modifyTeam(TeamsSchema team) {
		return projectDao.modifyTeam(team) > 0;
	}

	@Override
	public boolean deleteTeam(String teamId) {
		return projectDao.deleteTeam(teamId) > 0;
	}
	
}
