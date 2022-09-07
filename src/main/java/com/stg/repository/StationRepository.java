package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

	public Station findByLocation(String stationLocation);

	public Station findByStationNo(int stationNo);

	public Station findByStationName(String stationName);

}
