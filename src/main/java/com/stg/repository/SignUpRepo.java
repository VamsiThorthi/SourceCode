package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.SignUp;

public interface SignUpRepo extends JpaRepository<SignUp, Integer> {

	public  SignUp findByUserName(String userName);

}
