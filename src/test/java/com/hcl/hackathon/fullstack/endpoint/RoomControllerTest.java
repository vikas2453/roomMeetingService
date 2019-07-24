package com.hcl.hackathon.fullstack.endpoint;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.hackathon.fullstack.BaseTest;
import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.service.RoomService;

public class RoomControllerTest extends BaseTest {

	@MockBean
	private RoomService roomService;

	@Autowired
	private MockMvc mockMvc;	

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	LocalDate date;

	@DateTimeFormat(pattern = "HH:MM")
	LocalTime startTime;

	@DateTimeFormat(pattern = "HH:MM")
	LocalTime endTime;

	
	/*@InjectMocks
	RoomController controllerUnderTest;
	
	@Before
	public void setup() {

		// this must be called for the @Mock annotations above to be processed
		// and for the mock service to be injected into the controller under
		// test.
		MockitoAnnotations.initMocks(this);

		this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();

	}*/

	@Test
	public void testRoomController() throws Exception {
		date = LocalDate.of(2019, 7, 7);
		startTime = LocalTime.of(13, 00);
		endTime = LocalTime.of(14, 00);
		List<Room> testRooms = new ArrayList<>();
		testRooms.add(testRoom);

		doReturn(testRooms).when(roomService).filterListofRoom(date, startTime, endTime, "gainesville", "la", 1);

		mockMvc.perform(get("/rooms/{date}/{startTime}/{endTime}/{cityName}/{buildingName}/{floor}", "07-07-2017",
				"13:30", "14:00", "gainesville", "la", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].roomName", is("Cool room")))
				.andExpect(jsonPath("$[0].description", is("It's a cool room to code")))
				.andExpect(jsonPath("$[0].location.city", is("LocationName")));

		/*
		 * .andExpect(jsonPath("$[0].id", is(1)))
		 * .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
		 * .andExpect(jsonPath("$[0].title", is("Foo"))) .andExpect(jsonPath("$[1].id",
		 * is(2))) .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
		 * .andExpect(jsonPath("$[1].title", is("Bar")));
		 */
	}
}
