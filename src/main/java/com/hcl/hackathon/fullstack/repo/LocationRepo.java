package com.hcl.hackathon.fullstack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.hackathon.fullstack.model.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {

	@Query("select count(l)>0 from Location l where l.city=:city and l.buildingName=:buildingName")
	public boolean queryLocationByCityNBuildingName(@Param("city") String City, @Param("buildingName")String buildingName) ;
	
	public Location findByCityAndBuildingName( String city, String buildingName);
}
