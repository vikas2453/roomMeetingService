package com.hcl.hackathon.fullstack.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.hackathon.fullstack.model.BookedSlot;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookedSlotRepoTest {
	
	@Autowired
	private BookedSlotRepo bookedSlotRepo;
	
	@Test
	public void testfindByDateAndStartTime() {
		List<BookedSlot> bookedSlot= bookedSlotRepo.findByTimeSlotDateAndTimeSlotStartTime(LocalDate.of(2019, 7, 7), LocalTime.of(13, 30));
		Assert.assertNotNull(bookedSlot);
		Assert.assertEquals(bookedSlot.size(), 1);
	}
	

}
