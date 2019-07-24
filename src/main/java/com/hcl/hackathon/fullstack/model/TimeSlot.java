package com.hcl.hackathon.fullstack.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TimeSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int  TimeSlotId;
	
	private LocalDate date;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	
}
