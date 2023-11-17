package com.isaac.house.controller;

import com.isaac.house.handler.ResponseHandler;
import com.isaac.house.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/isaacHouse")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/room/get/{id}")
    public ResponseEntity<Object> fetchRoomById(@PathVariable long id){
        return ResponseHandler.generateResponse(HttpStatus.OK, roomService.getRoombyId(id));
    }
}
