package com.hcl.hackathon.fullstack.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookedSlot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int bookedSlotId;
	
	@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY)
	@JoinColumn(name="roomId")
	private Room room;
	
	

	@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY)
	@JoinColumn(name="TimeSlotId")
	private TimeSlot timeSlot;
	
	public BookedSlot(Room room, TimeSlot timeSlot) {
		super();
		this.room = room;
		this.timeSlot = timeSlot;
	}
	
}
