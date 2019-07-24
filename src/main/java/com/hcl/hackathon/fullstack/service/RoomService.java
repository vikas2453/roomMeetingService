package com.hcl.hackathon.fullstack.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.hackathon.fullstack.model.BookedSlot;
import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.repo.BookedSlotRepo;
import com.hcl.hackathon.fullstack.repo.RoomRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoomService {
	
	@Autowired
	private RoomRepo roomRepo;
	
	@Autowired
	private BookedSlotRepo bookedSlotRepo;
	
	@Transactional
	public List<Room> filterListofRoom( LocalDate date, 
			 LocalTime startTime, 
		 LocalTime endTime, String cityName, String buildingName, int floor){
		List<Room> totalRooms= roomRepo.findByLocationCityAndLocationBuildingNameAndLocationFloor(cityName, buildingName, floor);
		log.info("totalRooms:"+totalRooms);
		List<BookedSlot> bookedSlots=bookedSlotRepo.findByTimeSlotDateAndTimeSlotStartTime(date, startTime);
		Map<Integer, String> bookedRoomMap=getBookedMap(bookedSlots);
		log.info("bookedRoomMap "+bookedRoomMap);
		List<Room> availableRooms= filterRoomSlots(totalRooms, bookedRoomMap);
		log.info("availableRooms "+availableRooms);
		return availableRooms;
	}

	private Map<Integer, String> getBookedMap(List<BookedSlot> bookedSlots) {
		Map<Integer, String> bookedRoomMap = new HashMap<>();
		bookedSlots.forEach(s->bookedRoomMap.put(s.getRoom().getRoomId(), "booked"));
		return bookedRoomMap;
	}

	private List<Room> filterRoomSlots(List<Room> totalRooms, Map<Integer, String> bookedRoomMap) {
		List<Room> availableRooms=
		totalRooms.stream().filter(s->(!bookedRoomMap.containsKey(s.getRoomId()))).collect(Collectors.toList());
		return availableRooms;
	}

}
