package com.hcl.hackathon.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int locationId;
	
	private String city;	
	
	private int floor;
	
	private String buildingName;
	
	public Location(String city, int floor, String buildingName) {
		super();
		this.city = city;
		this.floor = floor;
		this.buildingName = buildingName;
	}


}
