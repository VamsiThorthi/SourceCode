package com.stg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.stg.entity.Bus;

public interface BusService {
    public abstract Bus createBus(Bus bus);

	public abstract Bus readByBusTypeAndBusNo(String busType, String busNo);

	public abstract Bus updateBus(String busNo,String newBusType);

	public abstract String deleteBusByBusNo(String busNo);
	
	public List<Bus> getBusesByDateAndStation(int stationId, LocalDate date);

	public abstract List<Bus> getBusesList();

}
