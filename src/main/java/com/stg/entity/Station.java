package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stationNo;
	private String stationName;
	private String location;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "station")
	private List<Bus> buses;
	public Station() {
		super();
	}
	public Station(int stationNo, String stationName, String location) {
		super();
		this.stationNo = stationNo;
		this.stationName = stationName;
		this.location = location;
	}
	public Station(int stationNo, String stationName, String location, List<Bus> buses) {
		super();
		this.stationNo = stationNo;
		this.stationName = stationName;
		this.location = location;
		this.buses = buses;
	}
	public int getStationNo() {
		return stationNo;
	}
	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Bus> getBuses() {
		return buses;
	}
	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}
	
	
}
