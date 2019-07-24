package com.hcl.hackathon.fullstack;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hcl.hackathon.fullstack.model.Amenity;
import com.hcl.hackathon.fullstack.model.Location;
import com.hcl.hackathon.fullstack.model.Room;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest {
	
	Location testLoc = new Location("LocationName", 5, "CoolBuildingName");
	Amenity testAmenity =  new Amenity(" confenrence room", " audio and video calling");
	protected Room testRoom = new Room.RoomBuilder()
			.roomName("Cool room")
			.description("It's a cool room to code")
			.maxoccupancy(5)
			.location(testLoc)
			.addAmenity(testAmenity)
			.build();

	
	
	public void contextLoads() {
	}
}
