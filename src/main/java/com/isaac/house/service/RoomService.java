package com.isaac.house.service;

import com.isaac.house.entity.Room;
import com.isaac.house.repository.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepo roomRepo;

    public Room createRoom(Room room){
        String roomName = room.getRoomName();
        Boolean isPublic = room.getIsPublic();
        if (roomName == null || roomName.isEmpty()) {
            throw new IllegalArgumentException("Room name cannot be null or empty");
        }

        // If isPublic is provided, validate its value
        if (isPublic != null && !Arrays.asList(true, false).contains(isPublic)) {
            throw new IllegalArgumentException("Invalid value for isPublic. It should be either true or false");
        }
        return roomRepo.save(room);
    }

    public List<Room> getAllRoom(){
        return roomRepo.findAll();
    }

    public Room getRoombyId(long id){
        return roomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + id)
                );
    }

}
