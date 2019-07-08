package com.hcl.hackathon.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Amenity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int amenityId;
	
	private String name;
	
	// Feature itself can be a class but for simplicity taking it as a String
	private String feature;

}
