package com.hcl.hackathon.fullstack.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Room> filterListofRoom(LocalDate date, LocalTime startTime, LocalTime endTime, String cityName,
			String buildingName, int floor) {
		List<Room> totalRooms = roomRepo.findByLocationCityAndLocationBuildingNameAndLocationFloor(cityName,
				buildingName, floor);

		List<BookedSlot> bookedSlots = bookedSlotRepo.findByTimeSlotDateAndTimeSlotStartTime(date, startTime);
		Map<Integer, String> bookedRoomMap = getBookedMap(bookedSlots);

		List<Room> availableRooms = filterRoomSlots(totalRooms, bookedRoomMap);

		return availableRooms;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	private Map<Integer, String> getBookedMap(List<BookedSlot> bookedSlots) {
		Map<Integer, String> bookedRoomMap = new HashMap<>();
		if (bookedSlots != null)
			bookedSlots.forEach(s -> bookedRoomMap.put(s.getRoom().getRoomId(), "booked"));
		return bookedRoomMap;
	}

	private List<Room> filterRoomSlots(List<Room> totalRooms, Map<Integer, String> bookedRoomMap) {
		List<Room> availableRooms = totalRooms.stream().filter(s -> (!bookedRoomMap.containsKey(s.getRoomId())))
				.collect(Collectors.toList());
		return availableRooms;
	}

}
