package com.ktdsuniv.instructor.user.dao;

import java.util.List;

import lecture.schema.LecturesSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserDao {

	public String getSalt(UsersSchema user);

	public InstructorsSchema instructorSignIn(UsersSchema user);

	public List<LecturesSchema> getInstructorLecture(InstructorsSchema instructor);

}
