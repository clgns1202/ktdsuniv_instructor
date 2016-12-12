package com.ktdsuniv.instructor.user.biz;

import java.util.List;

import lecture.schema.LecturesSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserBiz {

	public InstructorsSchema instructorSignIn(UsersSchema user);

	public List<LecturesSchema> getInstructorLecture(InstructorsSchema instructor);

}
