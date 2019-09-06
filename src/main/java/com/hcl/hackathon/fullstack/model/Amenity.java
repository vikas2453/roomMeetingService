package com.hcl.hackathon.fullstack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Amenity {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value="Id for amenity", example="1")
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
