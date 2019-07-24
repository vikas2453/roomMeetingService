package com.hcl.hackathon.fullstack.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.hackathon.fullstack.BaseTest;
import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.repo.RoomRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RoomServiceTest extends BaseTest{
	
	@Mock
	RoomRepo roomRepo;
	
	@Autowired
	RoomService roomService;
	
	@Test
	public void testFilterListofRoom() {
		LocalDate date = LocalDate.of(2019, 07, 07);
		LocalTime startTime= LocalTime.of(14, 30);
		LocalTime endTime= LocalTime.of(15, 00);
		String cityName="Salt Lake City";
		String buildingName= "Sweet Candy building";
		int floor=2;
		List<Room> availableRooms=roomService.filterListofRoom(date, startTime, endTime, cityName, buildingName, floor);
		assertNotNull(availableRooms);
		//log.info("availableRooms: "+availableRooms);
		assert(availableRooms.size()==1);
	}

}
