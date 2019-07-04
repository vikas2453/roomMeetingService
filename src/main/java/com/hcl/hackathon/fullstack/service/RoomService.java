package com.hcl.hackathon.fullstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.hackathon.fullstack.repo.RoomRepo;

@Service
public class RoomService {
	@Autowired
	private RoomRepo roomRepo;

}
