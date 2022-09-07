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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dealers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dealer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int dealerId;

	@Size(max = 256)
	@NotNull
	private String name;

	@Column(unique = true)
	@Size(max = 256)
	private String street;

	@NotNull
	@Size(max = 256)
	private String city;

	@NotNull
	@Size(max = 256)
	private String state;

	@NotNull
	private int zip;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dealer")
	@JsonManagedReference(value = "cardealer")
	private List<Car> cars;
}
