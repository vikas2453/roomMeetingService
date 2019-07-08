package com.hcl.hackathon.fullstack.repo;


import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.hackathon.fullstack.model.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepoTests {
	
	@Autowired
	private RoomRepo roomRepo;
	
	@Test
	//@Transactional
	public void testFindAllRooms() {
		List<Room> allRooms= roomRepo.findAll();
		assertNotNull(allRooms);
		
	}
	
	public void testFindRoomWithAmenity() {
		List<String> amenities= new ArrayList<>();
		amenities.add("Apple Remote call");
		List<Room> allRooms= roomRepo.findByLocationCityAndLocationBuildingNameAndLocationFloorAndAmenitiesNameIn("Salt Lake City", "Sweet Candy building", 1, amenities);
		assertNotNull(allRooms);
		
	}

}
