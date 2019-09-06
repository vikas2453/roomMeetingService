package com.hcl.hackathon.fullstack.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.hackathon.fullstack.config.Log;
import com.hcl.hackathon.fullstack.exceptions.InvalidRoomException;
import com.hcl.hackathon.fullstack.model.BookedSlot;
import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.model.TimeSlot;
import com.hcl.hackathon.fullstack.repo.BookedSlotRepo;
import com.hcl.hackathon.fullstack.repo.RoomRepo;

@Service
public class BookService {
	@Autowired
	private BookedSlotRepo bookedSlotRepo;

	@Autowired
	private RoomRepo roomRepo;

	@Autowired
	private TimeSlotRepo timeSlotRepo;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Log
	public BookedSlot book(int roomId, LocalDate date, LocalTime startTime, LocalTime endTime) {
		BookedSlot bookedSlot = null;	
		Room room =null;
		if (!roomRepo.existsById(roomId)) {
			throw new InvalidRoomException("Room id doesn't exist");
		}
		else {
			room=roomRepo.getOne(roomId);
		}
		TimeSlot timeSlot = getOrCreateTimeSlot(date, startTime, endTime);
		if (validate(room, timeSlot)) {
			bookedSlot = new BookedSlot(room, timeSlot);
			bookedSlot = bookedSlotRepo.save(bookedSlot);
			return bookedSlot;
		} else
			throw new InvalidRoomException(
					"Room Already booked at this time slot, Either please change the room or the time slot");

	}

	@Transactional(propagation = Propagation.MANDATORY, readOnly = true, isolation = Isolation.READ_COMMITTED)
	private boolean validate(Room room, TimeSlot timeSlot) {

		// validate if user is authorized to book the room
		// validate is room is available for booking, if not disabled by some flag
		// validate is room is available for booking at this timeSlot
		if (timeSlot.getTimeSlotId() == 0)
			return true;
		else
			return !bookedSlotRepo.findbyRoomIdAndSlotId(room, timeSlot);

	}

	@Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.READ_UNCOMMITTED)
	private TimeSlot getOrCreateTimeSlot(LocalDate date, LocalTime startTime, LocalTime endTime) {
		TimeSlot timeSlot = timeSlotRepo.findByDateAndStartTimeAndEndTime(date, startTime, endTime);
		if (timeSlot == null) {
			timeSlot = new TimeSlot(date, startTime, endTime);
			timeSlotRepo.save(timeSlot);
		}
		return timeSlot;
	}

}
