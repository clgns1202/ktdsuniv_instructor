package com.ktdsuniv.instructor.user.dao;

import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserDao {

	public String getSalt(UsersSchema user);

	public InstructorsSchema instructorSignIn(UsersSchema user);

}
