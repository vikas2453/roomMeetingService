package com.hcl.hackathon.fullstack.endPoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RoomController {
	
	private RoomService roomService;
	
	@RequestMapping(value="/roomDetails", method=RequestMethod.GET)
	public Room roomDetails() {
		return null;
		
	}

}
