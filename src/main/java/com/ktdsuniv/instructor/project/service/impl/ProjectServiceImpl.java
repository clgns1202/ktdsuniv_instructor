package com.ktdsuniv.instructor.project.service.impl;

import java.util.List;

import com.ktdsuniv.instructor.project.biz.ProjectBiz;
import com.ktdsuniv.instructor.project.service.ProjectService;

import common.mongo.biz.CommonBiz;
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.Pager;
import common.util.pager.PagerFactory;
import lecture.schema.LecturesSchema;
import project.schema.TeamsSchema;
import user.schema.UsersSchema;

public class ProjectServiceImpl implements ProjectService{

	private ProjectBiz projectBiz;
	private CommonBiz commonBiz;
	
	public void setProjectBiz(ProjectBiz projectBiz) {
		this.projectBiz = projectBiz;
	}

	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}

	@Override
	public UsersSchema getUserById(String id) {
		return commonBiz.getUserById(id);
	}

	@Override
	public boolean addTeam(TeamsSchema team) {
		return projectBiz.addTeam(team);
	}

	@Override
	public PageListVO getAllTeams(SearchVO search) {
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		search.setSearchKeyName("lectureId");
		return commonBiz.getMongoList(search, pager, TeamsSchema.class);
	}

	@Override
	public List<UsersSchema> getUsersByLectureId(String lectureId) {
		return projectBiz.getUsersByLectureId(lectureId);
	}

	@Override
	public UsersSchema getTest(String userId) {
		return commonBiz.getMongoById("userId", userId, UsersSchema.class);
	}

	@Override
	public PageListVO getListTest(SearchVO search) {
		
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		
		if(search.getSearchType() == 1){
			search.setSearchKeyName("address");
		}else if(search.getSearchType() == 2){
			search.setSearchKeyName("userId");
		}
		
		
		return commonBiz.getMongoList(search, pager, UsersSchema.class);
	}

	@Override
	public LecturesSchema getLectureById(String lectureId) {
		return commonBiz.getMongoById("_id", lectureId, LecturesSchema.class);
	}

	@Override
	public TeamsSchema getTeamById(String teamId) {
		return commonBiz.getMongoById("_id", teamId, TeamsSchema.class);
	}

	@Override
	public boolean modifyTeam(TeamsSchema team) {
		return projectBiz.modifyTeam(team);
	}
	
	
	
}
