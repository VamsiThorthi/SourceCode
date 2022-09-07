package com.auto.financeapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bankAccounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private  int accountId;

	@NotNull
	@Column(unique = true)
	private Long accountNumber;

	@NotNull
	private String accountHolderName;

	@NotNull
	@Size(max = 120)
	private String bankName;

	@NotNull
	@Size(max = 120)
	private String branchName;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
	@JsonBackReference(value = "userBankAccounts")
	private User user;

	@JsonManagedReference(value = "bankPayments")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bankAccount")
	private List<Payments> payments;

}
