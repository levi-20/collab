package com.cs.collabcall.service;

import com.cs.collabcall.entity.Room;
import com.cs.collabcall.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Room searchRoom(String roomName) {
        return repository.findByName(roomName);
    }

    public Room createRoom(String roomName, String description) {
        Room room = new Room();
        room.setName(roomName);
        room.setDescription(description);
        return repository.save(room);
    }

    public List<Room> listRooms() {
        return repository.findAll();
    }
}
