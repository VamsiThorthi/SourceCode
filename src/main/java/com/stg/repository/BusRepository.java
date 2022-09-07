package com.stg.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.entity.Bus;
import com.stg.entity.Station;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

	public Bus findBybusTypeAndBusNo(String busType, int busNo);

	public Bus findByBusNo(String busNo);

	public Bus findByBusType(String busType);
	
	@Query(value="SELECT * FROM bus b WHERE b.station_no=?1 AND bus_date=?2",nativeQuery = true)
	public List<Bus> getBusesByDateAndStation(int stationId, LocalDate date);
}
