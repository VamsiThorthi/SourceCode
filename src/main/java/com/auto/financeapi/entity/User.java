package com.auto.financeapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(unique = true, nullable = false)
	private String emailId;

	@Column(nullable = false, unique = true)

	private int mobileNumber1;

	@Column
	private int mobileNumber2;

	@Column
	private int mobileNumber3;

	@Column
	@Length(max = 120)
	private String lesseeFirstName;

	@Column
	@Length(max = 120)
	private String lesseLastName;

	@Column(nullable = false, unique = true)
	private String password;

	@JsonManagedReference(value = "userContracts")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Contract> contracts;

	@JsonManagedReference(value = "userBankAccounts")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<BankAccount> bankAccounts;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getMobileNumber1() {
		return mobileNumber1;
	}

	public void setMobileNumber1(int mobileNumber1) {
		this.mobileNumber1 = mobileNumber1;
	}

	public int getMobileNumber2() {
		return mobileNumber2;
	}

	public void setMobileNumber2(int mobileNumber2) {
		this.mobileNumber2 = mobileNumber2;
	}

	public int getMobileNumber3() {
		return mobileNumber3;
	}

	public void setMobileNumber3(int mobileNumber3) {
		this.mobileNumber3 = mobileNumber3;
	}

	public String getLesseeFirstName() {
		return lesseeFirstName;
	}

	public void setLesseeFirstName(String lesseeFirstName) {
		this.lesseeFirstName = lesseeFirstName;
	}

	public String getLesseLastName() {
		return lesseLastName;
	}

	public void setLesseLastName(String lesseLastName) {
		this.lesseLastName = lesseLastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

}
