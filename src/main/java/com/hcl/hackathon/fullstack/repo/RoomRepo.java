package com.hcl.hackathon.fullstack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.hackathon.fullstack.model.Room;

public interface RoomRepo extends JpaRepository<Room, Integer> {

}
