package com.ktdsuniv.instructor.project.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.project.service.ProjectService;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.ClassicPageExplorer;
import common.util.pager.PageExplorer;
import project.schema.TeamsSchema;
import user.schema.UsersSchema;

@Controller
public class ProjectController {

	private ProjectService projectService;
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@RequestMapping("/projects/teams/addTeam/{lectureId}")
	public ModelAndView viewAddTeamPage(@PathVariable String lectureId){
		
		//LecturesSchema lecture = projectService.getLectureById(lectureId);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("projectes/addTeam");
		//view.addObject("lecture", lecture);
		return view;
	}
	
	@RequestMapping("/projects/teams/doAddTeam")
	public String doAddTeamAction(TeamsSchema team, String[] userId){
		team.setCreatedDate(new Date());
		List<UsersSchema> users = new ArrayList<UsersSchema>();
		
		UsersSchema user = null;
		for (String id : userId) {
			//user = projectService.getUserById(id);
			
			user = new UsersSchema();
			user.setId(id);
			
			users.add(user);
		}
		
		team.setUser(users);
		projectService.addTeam(team);
		
		return "redirect:/projects/teams/list/"+team.getLectureId();
	}
	
	@RequestMapping("/projects/teams/list/{lectureId}")
	public ModelAndView viewTeamsList(SearchVO search, @PathVariable String lectureId){
		
		search.setIdType(true);
		search.setSearchKeyword(lectureId);
		PageListVO list = projectService.getAllTeams(search);
		
		PageExplorer pageExplorer = new ClassicPageExplorer(list.getPager());
		String page = pageExplorer.getPagingList("pageNumber", "[@]", "이전", "다음", "searchForm");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("projectes/teamsList");
		view.addObject("teamsList", list);
		view.addObject("page", page);
		view.addObject("seach", search);
		view.addObject("lectureId", lectureId);
		return view;
	}
	
	@RequestMapping("/projects/teams/users/{teamId}")
	@ResponseBody
	public List<UsersSchema> doGetUsersInTeamAction(@PathVariable String teamId){
		return projectService.getTeamById(teamId).getUser();
	}
	
	@RequestMapping("/projects/teams/modify/{teamId}")
	public ModelAndView viewModifyTeamPage(@PathVariable String teamId){
		
		TeamsSchema team = projectService.getTeamById(teamId);
		//LecturesSchema lecture = projectService.getLectureById(team.getLectureId());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("projectes/modifyTeam");
		//view.addObject("lecture", lecture);
		view.addObject("team", team);
		return view;
	}	
	
	@RequestMapping("/projects/teams/doModifyTeam")
	public String doModifyTeamAction(TeamsSchema team, String[] userId){
		List<UsersSchema> users = new ArrayList<UsersSchema>();
		
		UsersSchema user = null;
		for (String id : userId) {
			//user = projectService.getUserById(id);
			
			user = new UsersSchema();
			user.setId(id);
			
			users.add(user);
		}
		
		team.setUser(users);
		projectService.modifyTeam(team);
		return "redirect:/projects/teams/list/"+team.getLectureId();
	}

	@RequestMapping("/test")
	public ModelAndView test(SearchVO search){
		ModelAndView view = new ModelAndView();
		view.setViewName("test");
		view.addObject("test",projectService.getTest("5"));
		
		PageListVO list = projectService.getListTest(search);
		
		PageExplorer pageExplorer = new ClassicPageExplorer(list.getPager());
		String page = pageExplorer.getPagingList("pageNumber", "[@]", "이전", "다음", "searchForm");
		
		view.addObject("list", list);
		view.addObject("page", page);
		view.addObject("seach", search);
		
		return view;
	}	
	
}
