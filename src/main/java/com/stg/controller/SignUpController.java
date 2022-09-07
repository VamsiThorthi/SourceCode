package com.stg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.SignUp;

import com.stg.service.SignUpService;

@RequestMapping(value = "signUp")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SignUpController {
	@Autowired
	private SignUpService service;

	@PostMapping(value = "addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SignUp addUser(@RequestBody SignUp user) {

		return service.createUser(user);
	}

	@GetMapping(value = "getByNameAndPassword/{userName}/{password}")
	public SignUp readByNameAndPassword(@PathVariable String userName,@PathVariable String password) {

		return service.getUser(userName, password);
	}
}
