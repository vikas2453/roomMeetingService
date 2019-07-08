package com.hcl.hackathon.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class BookedSlot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int bookedSlotId;
	
	@ManyToOne
	@JoinColumn(name="roomId")
	private Room room;
	
	@ManyToOne
	@JoinColumn(name="TimeSlotId")
	private TimeSlot timeSlot;
	
	
	
}
