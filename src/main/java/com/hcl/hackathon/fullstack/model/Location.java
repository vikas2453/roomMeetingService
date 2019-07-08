package com.hcl.hackathon.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int locationId;
	
	private String city;
	
	private int floor;
	
	private String buildingName;

}
