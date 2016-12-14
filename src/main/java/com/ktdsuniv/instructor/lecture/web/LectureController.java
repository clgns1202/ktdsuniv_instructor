package com.ktdsuniv.instructor.lecture.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.lecture.service.LectureService;

import grades.schema.TestsSchema;
import user.schema.UsersSchema;

@Controller
public class LectureController {

	private LectureService lectureService;
	private Logger logger = LoggerFactory.getLogger(LectureController.class);
	
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}

	
	@RequestMapping("/lecture/scoreList/{lectureId}")
	public ModelAndView viewUserByLectureId(@PathVariable String lectureId){
		ModelAndView view = new ModelAndView();
		List<UsersSchema> users = lectureService.getUserByLectureId(lectureId);
		view.addObject("users", users);
		view.setViewName("lecture/scoreList");
		return view;
	}
	
	@RequestMapping("/lecture/addScore/{lectureId}")
	public ModelAndView addScorePage(@PathVariable String lectureId){
		ModelAndView view = new ModelAndView();
		List<UsersSchema> users = lectureService.getUserByLectureId(lectureId);
		view.addObject("lectureId", lectureId);
		view.addObject("users", users);
		view.setViewName("lecture/addScore");
		return view;
	}
	
	@RequestMapping("/lecture/inputScore")
	public ModelAndView inputScoreAction(@RequestParam List<Double> score, String lectureId, String testName){
		ModelAndView view = new ModelAndView();
		for (Double scores : score) {
			logger.debug("=================ss=="+lectureId);
			logger.debug("================dd==="+scores);
		}
		view.setViewName("redirect:/lecture/addScore/" + lectureId);
		return view;
	}
}
