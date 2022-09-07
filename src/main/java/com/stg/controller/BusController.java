package com.stg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Bus;
import com.stg.service.BusService;

@RestController
@RequestMapping(value = "bus")
@CrossOrigin(origins = "http://localhost:4200")
public class BusController {
	@Autowired
	private BusService busService;

	@PostMapping(value = "addBus")
	public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {

		return new ResponseEntity<Bus>(busService.createBus(bus), HttpStatus.OK);
	}

	@GetMapping(value = "getByBusTypeAndBusNo")
	public ResponseEntity<Bus> readByBusTypeAndBusNo(@RequestParam String BusType, @RequestParam String busNo) {
		return new ResponseEntity<Bus>(busService.readByBusTypeAndBusNo(BusType, busNo), HttpStatus.OK);
	}
	
	@GetMapping(value="getBusesByDate")
	public ResponseEntity<List<Bus>> readBusesByDateAndStation(@RequestParam int stationId,@RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date){
	
		return new ResponseEntity<List<Bus>>(busService.getBusesByDateAndStation(stationId, date), HttpStatus.OK);
	}
	@GetMapping(value="getBusesList")
	public List<Bus> readBuses(){
	
		return busService.getBusesList();
	}
	
	@PutMapping(value = "update")
	public ResponseEntity<Bus> updateByBusType(@RequestParam String busNo, @RequestParam String newBusType) {

		return new ResponseEntity<Bus>(busService.updateBus(busNo, newBusType), HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "deleteBusByBusNo")
	public ResponseEntity<String> deleteBusbyNo(@RequestParam String busNo) {

		return new ResponseEntity<String>(busService.deleteBusByBusNo(busNo), HttpStatus.OK);

	}
	
	

}
