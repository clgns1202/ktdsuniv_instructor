package com.ktdsuniv.instructor.user.biz;

import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserBiz {

	public InstructorsSchema instructorSignIn(UsersSchema user);

}
