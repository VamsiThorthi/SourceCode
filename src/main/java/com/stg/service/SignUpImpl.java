package com.stg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.SignUp;
import com.stg.entity.Station;
import com.stg.exception.SignUpException;
import com.stg.exception.StationException;
import com.stg.repository.BusRepository;
import com.stg.repository.SignUpRepo;
@Service
public class SignUpImpl implements SignUpService {
	
	@Autowired
	private SignUpRepo repo;
	

	@Override
	public SignUp createUser(SignUp user) {
		return repo.save(user);
	}

	@Override
	public SignUp getUser(String userName, String password) throws SignUpException {
		SignUp signUp = repo.findByUserName(userName);

		if (signUp == null) {
			throw new SignUpException("user not found");
		} else {
			if (signUp.getPassword().equals(password)) {

				return signUp;

			} else {
				throw new SignUpException("wrong password entered");
			}

		}
	}

}
