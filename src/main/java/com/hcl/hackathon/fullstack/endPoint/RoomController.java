package com.hcl.hackathon.fullstack.endPoint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/rooms")
public class RoomController {

	private RoomService roomService;

	@GET
	@Path("{date}/{startTime}/{endTime}/{cityName}/{buildingName}/{floor}")
	public List<Room> roomDetails(@PathParam("cityName") String cityName, 
			@PathParam("buildingName") String buildingName,
			@PathParam("floor") int floor, 
			@PathParam("date") LocalDate date, 
			@PathParam("startTime") LocalTime startTime, 
			@PathParam("endTime") LocalTime endTime) {
		return roomService.filterListofRoom(date, startTime, endTime, cityName, buildingName, floor);

	}

}
