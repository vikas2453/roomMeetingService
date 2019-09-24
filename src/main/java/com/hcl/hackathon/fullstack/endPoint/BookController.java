package com.hcl.hackathon.fullstack.endPoint;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hcl.hackathon.fullstack.config.Log;
import com.hcl.hackathon.fullstack.model.BookedSlot;
import com.hcl.hackathon.fullstack.service.BookService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/book")
	// TODO validations on BookedSlot
	// TODO exception handling on bookSlot
	@Log
	public BookedSlot bookSlot(int roomId,
			// @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			// LocalDate date,
			@RequestParam(value = "date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
			@RequestParam(value = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
			@RequestParam(value = "endTime") @DateTimeFormat(iso =DateTimeFormat.ISO.TIME) LocalTime endTime) {

		;

		BookedSlot bookedSlot = bookService.book(roomId, date, startTime, endTime);
		try {
			if (bookedSlot.getBookedSlotId() == 0)
				throw new NoSuchElementException();

		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking can't be done at this time", ex);
		}
		return bookedSlot;

	}

}
