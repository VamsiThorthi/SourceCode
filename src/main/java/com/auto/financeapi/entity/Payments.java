package com.auto.financeapi.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int paymentId;

	@NotNull
	private LocalDateTime paymentDate;

	@NotNull
	@Length(max = 10)
	private String status;

	@NotNull
	private int amount;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "bankAccountId", referencedColumnName = "accountId", nullable = false)
	@JsonBackReference(value = "bankPayments")
	private BankAccount bankAccount;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "contractId", referencedColumnName = "contractId", nullable = false)
	@JsonBackReference(value = "contractPayments")
	private Contract contract;

}
