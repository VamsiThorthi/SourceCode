package com.stg.service;

import java.util.List;

import com.stg.entity.Station;
import com.stg.exception.StationException;

public interface StationService {
	public abstract Station createHospital(Station station) throws StationException;

	public abstract Station readByStationName(String stationName) throws StationException;

	public abstract Station readByStationNameAndStationLocation(String stationName, String stationLocation)
			throws StationException;

	public abstract Station updateStation(String stationName, String newName) throws StationException;

	public abstract String deleteStationByName(String stationName) throws StationException;

	public abstract List<Station> readAllList();
}
