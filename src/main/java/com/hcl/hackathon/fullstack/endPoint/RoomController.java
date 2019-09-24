package com.hcl.hackathon.fullstack.endPoint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.fullstack.config.Log;
import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.service.RoomService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@Log
	@GetMapping({
			"/rooms/{date}/{startTime}/{endTime}/{cityName}/{buildingName}/{floor}",
			 "/rooms/{date}/{startTime}/{endTime}/{cityName}/{buildingName}", 
			 "/rooms/{date}/{startTime}/{endTime}/{cityName}",
			 "/rooms/{date}/{startTime}/{endTime}",
			 "/rooms"
			 })
	// @GetMapping(value = "/rooms/{cityName}/{buildingName}/{floor}")
	public List<Room> roomDetails(@PathVariable(value="cityName", required=false) String cityName,
			@PathVariable(value = "buildingName", required = false) String buildingName,
			@PathVariable(value = "floor", required = false) Integer floor,
			@PathVariable(value = "date", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
			//@PathVariable(value = "startTime", required = false) @DateTimeFormat(pattern = "HH:MM") LocalTime startTime,
			@PathVariable(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
			@PathVariable(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {

		log.info("startTime+ " + startTime);

		List<Room> roomreturned = roomService.filterListofRoom(date, startTime, endTime, cityName, buildingName, floor);
		return roomreturned;

	}

	@PutMapping(value = "/room")
	public Room addRoom(@Valid Room room) {
		roomService.add(room);
		return room;

	}

}
