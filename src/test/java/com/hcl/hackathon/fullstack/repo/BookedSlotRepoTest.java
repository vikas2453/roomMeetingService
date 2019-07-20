package com.hcl.hackathon.fullstack.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.hackathon.fullstack.BaseTest;
import com.hcl.hackathon.fullstack.model.BookedSlot;


public class BookedSlotRepoTest extends BaseTest{
	
	@Autowired
	private BookedSlotRepo bookedSlotRepo;
	
	@Test
	public void testfindByDateAndStartTime() {
		List<BookedSlot> bookedSlot= bookedSlotRepo.findByTimeSlotDateAndTimeSlotStartTime(LocalDate.of(2019, 7, 7), LocalTime.of(13, 30));
		Assert.assertNotNull(bookedSlot);
		Assert.assertEquals(bookedSlot.size(), 1);
	}
	

}
