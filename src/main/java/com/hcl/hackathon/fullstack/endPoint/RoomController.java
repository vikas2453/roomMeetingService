package com.hcl.hackathon.fullstack.endPoint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping(value = "/rooms/{date}/{startTime}/{endTime}/{cityName}/{buildingName}/{floor}")
	//@GetMapping(value = "/rooms/{cityName}/{buildingName}/{floor}")
	public List<Room> roomDetails(@PathVariable("cityName") String cityName,
			@PathVariable(value = "buildingName", required = false) String buildingName,
			@PathVariable(value = "floor", required = false) Integer floor,
			@PathVariable(value = "date", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
			@PathVariable(value = "startTime", required = false) @DateTimeFormat(pattern = "HH:MM") LocalTime startTime,
			@PathVariable(value = "endTime", required = false) @DateTimeFormat(pattern = "HH:MM") LocalTime endTime
			) {
	
		log.info("startTime+ "+startTime);
	
		List<Room>roomreturned= roomService.filterListofRoom(date, startTime, endTime, cityName, buildingName, floor);
		return roomreturned;

	}

}
