package com.ktdsuniv.instructor.lecture.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.lecture.service.LectureService;

import lecture.schema.LecturesSchema;
import user.schema.UsersSchema;

@Controller
public class LectureController {

	private LectureService lectureService;
	
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	
	@RequestMapping("/lecture/detail/{lectureId}")
	public ModelAndView viewDetailLecture(@PathVariable String lectureId){
		ModelAndView view = new ModelAndView();
		LecturesSchema lecture = lectureService.getDetailLecture(lectureId);
		view.addObject("lecture", lecture);
		view.setViewName("lecture/detail");
		return view;
	}

	@RequestMapping("/lecture/userDetail/{lectureId}")
	public ModelAndView viewDetailLectureUser(@PathVariable String lectureId){
		ModelAndView view = new ModelAndView();
		LecturesSchema lecture = lectureService.getDetailLectureUsers(lectureId);
		view.addObject("lecture", lecture);
		view.setViewName("lecture/userDetail");
		return view;
	}
}
