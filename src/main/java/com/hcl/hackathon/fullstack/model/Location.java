package com.hcl.hackathon.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	@JsonIgnore
	@ApiModelProperty(required = false, hidden = true)
	private int locationId;
	
	@ApiModelProperty(example="Salt Lake City")
	private String city;	
	
	@ApiModelProperty(example="2")
	private int floor;
	
	@ApiModelProperty(example="Sweet Candy building")
	private String buildingName;
	
	public Location(String city, int floor, String buildingName) {
		super();
		this.city = city;
		this.floor = floor;
		this.buildingName = buildingName;
	}


}
