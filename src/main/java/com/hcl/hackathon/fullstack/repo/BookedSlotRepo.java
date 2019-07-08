package com.hcl.hackathon.fullstack.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.hackathon.fullstack.model.BookedSlot;

public interface BookedSlotRepo extends JpaRepository<BookedSlot, Integer> {
	
	public List<BookedSlot> findByTimeSlotDateAndTimeSlotStartTime(LocalDate date, LocalTime startTime );

}
