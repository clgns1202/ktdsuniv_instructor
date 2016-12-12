package com.ktdsuniv.instructor.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import lecture.schema.LecturesSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserService {

	public boolean instructorSignIn(UsersSchema user, HttpSession session);

	public List<LecturesSchema> getInstructorLecture(HttpSession session);



}
