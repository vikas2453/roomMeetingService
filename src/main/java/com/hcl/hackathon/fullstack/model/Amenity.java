package com.hcl.hackathon.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Amenity {
	
	@Id
	private int amenityId;
	
	private String name;
	
	// Feature itself can be a class but for simplicity taking it as a String
	private String feature;

}
