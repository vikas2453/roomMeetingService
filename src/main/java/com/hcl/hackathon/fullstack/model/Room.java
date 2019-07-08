package com.hcl.hackathon.fullstack.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomId;
	
	private String roomName;
	
	private String description;
	
	@OneToMany
	private List<Amenity> amenities;
	
	@OneToOne
	private Location location;
	
	private int maxoccupancy;
	
	/*@Transient
	List<TimeSlot> availableSlots;*/


}
