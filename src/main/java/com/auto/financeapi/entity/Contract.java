package com.auto.financeapi.entity;

import java.time.LocalDateTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contracts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int contractId;

	@NotNull
	@Size(max = 16)
	private String type;

	@NotNull
	private int term;

	@NotNull
	private float amount;

	@NotNull
	private int milesAllowed;

	@NotNull
	private LocalDateTime startDate;

	@NotNull
	private LocalDateTime maturityDate;

	@OneToOne
	@JoinColumn(name = "carId", referencedColumnName = "carId")
	@NotNull
	@JsonBackReference(value = "carContract")
	private Car car;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
	@JsonBackReference(value = "userContracts")
	private User user;

	@JsonManagedReference(value = "contractPayments")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contract")
	private List<Payments> payments;

}
