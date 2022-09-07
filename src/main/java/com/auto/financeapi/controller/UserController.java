package com.auto.financeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.financeapi.entity.AuthRequest;
import com.auto.financeapi.entity.ResponseSuccess;
import com.auto.financeapi.service.impl.UserService;

@RestController
@RequestMapping(value = "stgit.com/financeapi")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "v1/users")
	public ResponseEntity<ResponseSuccess> signUpUser(@RequestBody AuthRequest authRequest) {
		return userService.signUpUser(authRequest);
	}
}
