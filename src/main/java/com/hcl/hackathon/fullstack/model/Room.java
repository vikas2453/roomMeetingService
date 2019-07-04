package com.hcl.hackathon.fullstack.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Room {
	
	@Id
	private int roomId;
	
	@OneToMany
	private List<Amenity> amenities;
	
	@OneToOne
	private Location location;

}
