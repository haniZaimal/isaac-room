package com.isaac.house.controller;

import com.isaac.house.entity.Room;
import com.isaac.house.handler.ResponseHandler;
import com.isaac.house.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/isaacHouse")
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/room/create")
    public ResponseEntity<Object> createRoom(@RequestBody Room room){
        return ResponseHandler.generateResponse(HttpStatus.OK, roomService.createRoom(room));
    }

    @GetMapping("/room/get/{id}")
    public ResponseEntity<Object> fetchRoomById(@PathVariable long id){
        return ResponseHandler.generateResponse(HttpStatus.OK, roomService.getRoombyId(id));
    }
}
