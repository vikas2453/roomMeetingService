package com.hcl.hackathon.fullstack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity

public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int roomId;

	//public static RoomBuilder roomBuilder;

	private String roomName;

	private String description;

	@OneToMany
	private List<Amenity> amenities;

	@OneToOne
	private Location location;

	private int maxoccupancy;

	public Room() {

	}

	public Room(String roomName, String description, List<Amenity> amenities, Location location, int maxoccupancy) {
		this.roomName = roomName;
		this.description = description;
		this.maxoccupancy = maxoccupancy;
		this.location = location;
		this.amenities = amenities;
	}

	/*
	 * @Transient List<TimeSlot> availableSlots;
	 */

	public static class RoomBuilder {
		private String roomName;

		private String description;

		@OneToMany
		private List<Amenity> amenities = new ArrayList<>();

		@OneToOne
		private Location location;

		private int maxoccupancy;

		public RoomBuilder roomName(String roomName) {
			this.roomName = roomName;
			return this;
		}

		public RoomBuilder description(String description) {
			this.description = description;
			return this;
		}

		public RoomBuilder location(Location location) {
			this.location = location;
			return this;
		}

		public RoomBuilder maxoccupancy(int maxoccupancy) {
			this.maxoccupancy = maxoccupancy;
			return this;
		}

		public RoomBuilder addAmenity(Amenity amenity) {
			amenities.add(amenity);
			return this;
		}

		public Room build() {
			return new Room(roomName, description, amenities, location, maxoccupancy);
		}

	}

}
