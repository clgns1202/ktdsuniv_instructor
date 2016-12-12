package com.ktdsuniv.instructor.grade.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.grade.service.GradeService;

import grades.schema.GradesSchema;
import grades.schema.Tests;
import user.schema.UsersSchema;


@Controller
public class GradeController {

	private GradeService gradeService;
	private Logger logger = LoggerFactory.getLogger(GradeController.class);
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	
	@RequestMapping("/grade/list/{lectureName}")
	public ModelAndView viewGradeByLecture(@PathVariable String lectureName){
		ModelAndView view = new ModelAndView();
		List<GradesSchema> gradeList = gradeService.getGradeListByLecture(lectureName);
		
		for (GradesSchema gradesSchema : gradeList) {
			logger.debug("====================================================="+gradesSchema.getLecture().getLectureName());
		}
		
		view.addObject("gradeList", gradeList);
		view.setViewName("grade/list");
		
		return view;
	}
	
	@RequestMapping("/grade/addGrade/{lectureId}")
	public ModelAndView viewAddGradePage(@PathVariable String lectureId){
		ModelAndView view = new ModelAndView();
		List<UsersSchema> userList = gradeService.getAllUserByLecture(lectureId);
		view.addObject("userList", userList);
		view.addObject("lectureId", lectureId);
		view.setViewName("/grade/addGrade");
		return view;
	}
	
	@RequestMapping("/grade/doAddGrade")
	public ModelAndView addNewGrade(Tests test, @RequestParam String userId, @RequestParam String lectureId){
		ModelAndView view = new ModelAndView();
		
		logger.debug("유저 아이디"+userId);
		logger.debug("강의 아이디"+lectureId);
		
		boolean isSuccess = gradeService.addNewGrade(test, userId, lectureId);
		view.setViewName("redirect://grade/addGrade/"+lectureId);
		return view;
	}
	
}
