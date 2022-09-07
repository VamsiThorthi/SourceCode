package com.stg.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.stg.entity.Station;
import com.stg.exception.BusException;
import com.stg.exception.StationException;
import com.stg.repository.StationRepository;

@Service
public class StationServiceImpl implements StationService {
	@Autowired
	private StationRepository stationRepository;

	@Override
	public Station createHospital(Station station) throws StationException {
		return stationRepository.save(station);
	}

	@Override
	public Station readByStationName(String stationName) throws StationException {
		List<Station> stations = stationRepository.findAll();
		Station stationTemp = null;
		for (Station station : stations) {
			if (station.getStationName().equals(stationName)) {
				stationTemp = station;
			}

		}
		if (stationTemp == null) {
			throw new StationException("Station not found with given station name");
		} else {
			return stationTemp;
		}

	}

	@Override
	public Station readByStationNameAndStationLocation(String stationName, String stationLocation)
			throws StationException {

		Station station = stationRepository.findByLocation(stationLocation);

		if (station == null) {
			throw new StationException("Station not found with that Location");
		} else {
			if (station.getStationName().equalsIgnoreCase(stationName)) {

				return station;

			} else {
				throw new StationException("Station not found with that name");
			}

		}

	}

	@Override
	public Station updateStation(String stationName, String newName) throws StationException {
		Station stationTemp = stationRepository.findByStationName(stationName);

		if (stationTemp != null) {

			stationTemp.setStationName(newName);
			return stationRepository.save(stationTemp);
		} else {
			throw new StationException("station name not found");
		}

	}

	@Override
	public String deleteStationByName(String stationName) throws StationException {
		Station station = stationRepository.findByStationName(stationName);

		if (station == null) {
			throw new StationException("No such station to delete");

		} else {
			stationRepository.delete(station);
			return "deleted";
		}

	}

	@Override
	public List<Station> readAllList() {
		List<Station> stations = stationRepository.findAll();
		
		return stations;
	}

}
