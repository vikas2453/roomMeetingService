package com.hcl.hackathon.fullstack.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.hcl.hackathon.fullstack.BaseTest;
import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.repo.BookedSlotRepo;
import com.hcl.hackathon.fullstack.repo.RoomRepo;

public class RoomServiceTest extends BaseTest{
	
	@Mock
	RoomRepo roomRepo;
	
	@Mock
	private BookedSlotRepo bookedSlotRepo;
	
	@InjectMocks
	RoomService roomService;
	
	@Test
	public void testFilterListofRoom() {
		testRooms.add(testRoom);
		LocalDate date = LocalDate.of(2019, 07, 07);
		LocalTime startTime= LocalTime.of(14, 30);
		LocalTime endTime= LocalTime.of(15, 00);
		String cityName="CityName";
		String buildingName= "Sweet Candy building";
		int floor=2;
		
		doReturn(testRooms).when(roomRepo).findByLocationCityAndLocationBuildingNameAndLocationFloor( cityName, buildingName, floor);
		doReturn(null).when(bookedSlotRepo).findByTimeSlotDateAndTimeSlotStartTime( date, startTime);
		
		List<Room> availableRooms=roomService.filterListofRoom(date, startTime, endTime, cityName, buildingName, floor);
		assertNotNull(availableRooms);
		//log.info("availableRooms: "+availableRooms);
		assertThat(availableRooms.size(), is(1));
	}

}
