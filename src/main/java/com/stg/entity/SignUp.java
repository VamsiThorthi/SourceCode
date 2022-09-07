package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class SignUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String userName;
	private String gender;
	private String email;
	private String Password;
	public SignUp() {
		super();
	}
	
	public SignUp(int userId, String firstName, String lastName, String userName, String gender, String email,
			String Password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.Password = Password;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
