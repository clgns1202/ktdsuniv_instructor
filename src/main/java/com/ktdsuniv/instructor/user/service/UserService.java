package com.ktdsuniv.instructor.user.service;

import javax.servlet.http.HttpSession;

import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserService {

	public boolean instructorSignIn(UsersSchema user, HttpSession session);


}
