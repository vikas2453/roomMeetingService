package com.hcl.hackathon.fullstack.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.hackathon.fullstack.model.TimeSlot;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Integer> {
	
	public TimeSlot findByDateAndStartTimeAndEndTime(LocalDate date, LocalTime startTime,  LocalTime EndTime );

}
