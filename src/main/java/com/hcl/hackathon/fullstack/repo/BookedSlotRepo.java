package com.hcl.hackathon.fullstack.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.hackathon.fullstack.model.BookedSlot;
import com.hcl.hackathon.fullstack.model.Room;
import com.hcl.hackathon.fullstack.model.TimeSlot;

public interface BookedSlotRepo extends JpaRepository<BookedSlot, Integer> {
	
	public List<BookedSlot> findByTimeSlotDateAndTimeSlotStartTime(LocalDate date, LocalTime startTime );

	@Query("select count(e)>0 from BookedSlot e where e.room=:room and e.timeSlot=:timeSlot")
	public boolean findbyRoomIdAndSlotId(@Param("room") Room room, @Param("timeSlot") TimeSlot timeSlot);
	

}
