package com.hcl.hackathon.fullstack.endpoint;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.hackathon.fullstack.BaseTest;

public class RoomControllerIntegrationTest extends BaseTest {

	
	@Autowired
	private MockMvc mockMvc;	

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	LocalDate date;

	@DateTimeFormat(pattern = "HH:MM")
	LocalTime startTime;

	@DateTimeFormat(pattern = "HH:MM")
	LocalTime endTime;

	
	@Test
	public void testRoomController() throws Exception {
		
		mockMvc.perform(get("/rooms/{date}/{startTime}/{endTime}/{cityName}/{buildingName}/{floor}", "07-07-2017",
				"13:30", "14:00", "Salt Lake City", "Sweet Candy building", 2)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].roomName", is("Death star")))
				.andExpect(jsonPath("$[0].description", is("Large room on the second floor")))
				.andExpect(jsonPath("$[0].location.city", is("Salt Lake City")));

		/*
		 * .andExpect(jsonPath("$[0].id", is(1)))
		 * .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
		 * .andExpect(jsonPath("$[0].title", is("Foo"))) .andExpect(jsonPath("$[1].id",
		 * is(2))) .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
		 * .andExpect(jsonPath("$[1].title", is("Bar")));
		 */
	}
}
