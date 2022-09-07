package com.auto.financeapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int carId;

	@Column(unique = true)
	private int vin;

	@NotNull
	private int year;

	@Size(max = 64)
	@NotNull
	private String model;

	@Column(length = 999999999)
	@NotNull
	private byte[] image;

	@OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "carContract")
	private Contract contract;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dealerId", nullable = false)
	@JsonBackReference(value = "cardealer")
	private Dealer dealer;

}
