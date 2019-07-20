package com.hcl.hackathon.fullstack.repo;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.hackathon.fullstack.BaseTest;
import com.hcl.hackathon.fullstack.model.Amenity;
import com.hcl.hackathon.fullstack.model.Location;
import com.hcl.hackathon.fullstack.model.Room;

public class RoomRepoTests extends BaseTest {

	@Autowired
	private RoomRepo roomRepo;

	@Test
	@Transactional
	public void testSave() {
		Location loc = new Location("LocationName", 5, "CoolBuildingName");
		Amenity amenity =  new Amenity(" confenrence room", " audio and video calling");
		Room room = new Room.RoomBuilder()
				.roomName("Cool room")
				.description("It's a cool room to code")
				.maxoccupancy(5)
				.location(loc)
				.addAmenity(amenity)
				.build();
		roomRepo.save(room);
	}

	@Test
	// @Transactional
	public void testFindAllRooms() {
		List<Room> allRooms = roomRepo.findAll();
		assertNotNull(allRooms);

	}

	public void testFindRoomWithAmenity() {
		List<String> amenities = new ArrayList<>();
		amenities.add("Apple Remote call");
		List<Room> allRooms = roomRepo.findByLocationCityAndLocationBuildingNameAndLocationFloorAndAmenitiesNameIn(
				"Salt Lake City", "Sweet Candy building", 1, amenities);
		assertNotNull(allRooms);

	}

}
