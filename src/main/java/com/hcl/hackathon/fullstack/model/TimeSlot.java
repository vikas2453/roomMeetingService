package com.hcl.hackathon.fullstack.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TimeSlot {
	@Id
	int  TimeSlotId;
	
	private Instant startTime;
	
	private Instant endTime;

}
