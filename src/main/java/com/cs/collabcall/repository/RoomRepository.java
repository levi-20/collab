package com.cs.collabcall.repository;

import com.cs.collabcall.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByName(String name);
}
