package com.hcl.hackathon.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Amenity {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int amenityId;
	
	private String name;
	
	// Feature itself can be a class but for simplicity taking it as a String
	private String feature;
	public Amenity(String name, String feature) {
		super();
		this.name = name;
		this.feature = feature;
	}

}
