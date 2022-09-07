package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Bus;
import com.stg.entity.Station;
import com.stg.service.StationService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "station")
public class StationController {
	@Autowired
	private StationService stationService;

	@PostMapping(value = "addStation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Station> addStation(@RequestBody Station station) {

		return new ResponseEntity<Station>(stationService.createHospital(station), HttpStatus.OK);
	}

	@GetMapping(value = "read/{stationName}")
	public ResponseEntity<Station> readStationById(@PathVariable String stationName) {
		return new ResponseEntity<Station>(stationService.readByStationName(stationName), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "getList")
	public ResponseEntity<List<Station>> readAll() {
		return new ResponseEntity<List<Station>>(stationService.readAllList(), HttpStatus.OK);
	}

	@GetMapping(value = "getByNameAndLocation")
	public ResponseEntity<Station> readByStationByNameAndId(@RequestParam String stationName,
			@RequestParam String stationLocation) {

		return new ResponseEntity<Station>(
				stationService.readByStationNameAndStationLocation(stationName, stationLocation), HttpStatus.OK);
	}

	@PutMapping(value = "update/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Station> updateStation( @RequestParam String stationName,@RequestParam String newName) {

		return new ResponseEntity<Station>(stationService.updateStation(stationName,newName),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/{stationName}")
	public ResponseEntity<String> deleteStationByName(@PathVariable("stationName") String stationName) {

		return new ResponseEntity<String>(stationService.deleteStationByName(stationName), HttpStatus.OK);
	}
	
	
}
