package com.hcl.hackathon.fullstack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.hackathon.fullstack.model.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {
	//@Query("select room from Room where room.location.city=: cityName")
	
	public List<Room> findByLocationCityAndLocationBuildingNameAndLocationFloorAndAmenitiesNameIn( String cityName, String buildingName,int floor,  List<String> ameneites);
	public List<Room> findByLocationCityAndLocationBuildingNameAndLocationFloor( String cityName, String buildingName,int floor);
	public List<Room> findByLocationCityAndLocationBuildingName( String cityName, String buildingName);
	public List<Room> findByLocationCity( String cityName);

}
