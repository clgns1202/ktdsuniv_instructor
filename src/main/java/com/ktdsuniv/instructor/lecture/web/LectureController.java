package com.ktdsuniv.instructor.lecture.web;

import org.springframework.stereotype.Controller;

import com.ktdsuniv.instructor.lecture.service.LectureService;

@Controller
public class LectureController {

	private LectureService lectureService;
	
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
}
