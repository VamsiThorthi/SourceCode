package com.stg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
@RequestMapping(value = "bus")
@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	@NonNull
	private String busNo;
	private String busType;
	private String seatType;
	@JsonBackReference
	@JoinColumn(name = "station_no",referencedColumnName = "stationNo", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	private Station station;
	//@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	@Column(nullable = false)
	private LocalDate busDate;
	
	public Bus() {
		super();
	}
	public Bus(int busId, String busNo, String busType, String seatType) {
		super();
		this.busId = busId;
		this.busNo = busNo;
		this.busType = busType;
		this.seatType = seatType;
	}
	public Bus(int busId, String busNo, String busType, String seatType, Station station,LocalDate busDate) {
		super();
		this.busId = busId;
		this.busNo = busNo;
		this.busType = busType;
		this.seatType = seatType;
		this.station = station;
		this.busDate =busDate;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public LocalDate getBusDate() {
		return busDate;
	}
	public void setBusDate(LocalDate busDate) {
		this.busDate = busDate;
	}
	
	
	
	
}
