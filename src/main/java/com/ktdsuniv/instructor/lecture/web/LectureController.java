package com.ktdsuniv.instructor.lecture.web;

import java.util.ArrayList;
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
	
	/*
	 * 강의를 신청한 사람들의 목록을 보여준다.
	 */
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
	public ModelAndView inputScoreAction(@RequestParam List<Double> scores, @RequestParam List<String> userIds, TestsSchema test){
		ModelAndView view = new ModelAndView();
		
		List<UsersSchema> usersSchemas = new ArrayList<UsersSchema>();
		List<TestsSchema> testsSchemas = null;
		
		UsersSchema usersSchema = null;
		TestsSchema testsSchema = null;
		for ( int i = 0; i < scores.size(); i++ ) {
			usersSchema = new UsersSchema();
			usersSchema.setUserId(userIds.get(i));
			
			testsSchema = new TestsSchema();
			testsSchema.setScore(scores.get(i));
			testsSchema.setTestName(test.getTestName());
			testsSchema.setLectureId(test.getLectureId());
			testsSchemas = new ArrayList<TestsSchema>();
			testsSchemas.add(testsSchema);
			usersSchema.setTests(testsSchemas);
			
			usersSchemas.add(usersSchema);
		}
		
		boolean isSuccess = lectureService.inputScoreByLectureId(usersSchemas);
		view.setViewName("redirect:/lecture/addScore/" + test.getLectureId());
		return view;
	}
}
