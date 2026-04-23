package com.cs.collabcall.service;

import com.cs.collabcall.dto.RoomResponse;
import com.cs.collabcall.entity.Room;
import com.cs.collabcall.repository.RoomRepository;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {

        this.repository = repository;
    }

    public Optional<RoomResponse> searchRoomByName(String roomName) {

        log.info("Search by room name: {}", roomName);
        return repository.findByName(roomName)
            .map(this::toResponse);
    }

    public List<RoomResponse> listRooms() {

        log.info("Querying all rooms");
        return repository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    public RoomResponse createRoom(Room room) {

        log.info("Creating room with name: {}", room.getName());
        return toResponse(repository.save(room));
    }

    public void deleteRoomById(Long id) {

        log.info("Deleting room: {}", id);
        repository.deleteById(id);
    }

    public Optional<RoomResponse> roomById(Long id) {

        return repository.findById(id)
            .map(this::toResponse);
    }

    public List<RoomResponse> searchRooms(String searchTerm) {

        return repository.findByNameContainingIgnoreCase(searchTerm)
            .stream()
            .map(this::toResponse)
            .toList();
    }

    public RoomResponse toResponse(Room room) {
        return new RoomResponse(
            room.getId(),
            room.getName(),
            room.getDescription(),
            room.getCreatedAt(),
            room.getCreatedBy()
        );
    }

    public List <RoomResponse> searchRoomsByUser(UUID userId) {

        return repository.findRoomsByCreatedBy(userId)
            .stream()
            .map(this::toResponse)
            .toList();
    }
}
