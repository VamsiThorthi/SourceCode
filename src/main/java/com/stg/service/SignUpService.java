package com.stg.service;

import com.stg.entity.SignUp;

public interface SignUpService {
	public abstract SignUp createUser(SignUp user);
	public abstract SignUp getUser(String userName,String password);
}
