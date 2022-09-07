package com.auto.financeapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auto.financeapi.entity.AuthRequest;
import com.auto.financeapi.entity.ResponseSuccess;
import com.auto.financeapi.entity.User;
import com.auto.financeapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;

	public UserServiceImpl() {
		super();

		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public ResponseEntity<ResponseSuccess> signUpUser(AuthRequest authRequest) {

		User user = new User();
		String encodedPassword = this.passwordEncoder.encode(authRequest.getPassword());
		user.setEmailId(authRequest.getEmailId());
		user.setMobileNumber1(authRequest.getMobileNumber1());
		user.setPassword(encodedPassword);
		ResponseSuccess responseSuccess = new ResponseSuccess("You are registred successfully");
		userRepository.save(user);

		return new ResponseEntity<ResponseSuccess>(responseSuccess, HttpStatus.CREATED);
	}

}
