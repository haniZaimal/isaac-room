package com.isaac.house.service;

import com.isaac.house.entity.Room;
import com.isaac.house.repository.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepo roomRepo;

    public Room getRoombyId(long id){
        return roomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + id)
                );
    }

}
