package com.stg.service;

import java.time.LocalDate;
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

import com.stg.entity.Bus;
import com.stg.exception.BusException;
import com.stg.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService {
	@Autowired
	private BusRepository busRepository;

	@Override
	public Bus createBus(Bus bus) {

		return busRepository.save(bus);
	}

	@Override
	public Bus readByBusTypeAndBusNo(String busType, String busNo) throws BusException {

		if (busRepository.findByBusNo(busNo) == null) {
			throw new BusException("The Bus is not found with the given bus No");
		} else {
			if (busRepository.findByBusNo(busNo).getBusType().equals(busType)) {
				return busRepository.findByBusNo(busNo);
			} else {

				throw new BusException("The Bus is not with the given details");
			}
		}

	}

	@Override
	public Bus updateBus(String busNo, String newBusType) throws BusException {
		Bus busTemp = busRepository.findByBusNo(busNo);
		if (busTemp == null) {
			throw new BusException("No Bus Exists with the bus No");
		} else {
			if (busTemp.getBusType().equalsIgnoreCase(newBusType)) {
				throw new BusException("already the bus type is same");
			} else {

				busTemp.setBusType(newBusType);
				return busRepository.save(busTemp);
			}

		}
	}

	@Override
	public String deleteBusByBusNo(String busNo) throws BusException {
		Bus bus = busRepository.findByBusNo(busNo);

		if (bus == null) {
			throw new BusException("Bus not found with the given No");

		} else {
			busRepository.delete(bus);

			return "Bus deleted";
		}

	}

	public List<Bus> getBusesByDateAndStation(int stationId, LocalDate date) throws BusException {
		List<Bus> buses = busRepository.getBusesByDateAndStation(stationId, date);
		if (buses != null) {
			return buses;
		} else {
			throw new BusException("No Buses in the respective date for the station");
		}
	}

	@Override
	public List<Bus> getBusesList() {
		return busRepository.findAll();
	}
}
