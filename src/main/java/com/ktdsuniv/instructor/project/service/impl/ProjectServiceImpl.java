package com.ktdsuniv.instructor.project.service.impl;

import com.ktdsuniv.instructor.project.biz.ProjectBiz;
import com.ktdsuniv.instructor.project.service.ProjectService;

public class ProjectServiceImpl implements ProjectService{

	private ProjectBiz projectBiz;
	
	public void setProjectBiz(ProjectBiz projectBiz) {
		this.projectBiz = projectBiz;
	}
	
}
