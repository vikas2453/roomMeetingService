package com.hcl.hackathon.fullstack.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TimeSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int TimeSlotId;

	private LocalDate date;

	private LocalTime startTime;

	private LocalTime endTime;
	
	public TimeSlot(LocalDate date, LocalTime startTime, LocalTime endTime) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}

}
