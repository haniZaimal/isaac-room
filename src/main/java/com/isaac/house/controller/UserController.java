package com.isaac.house.controller;

import com.isaac.house.entity.User;
import com.isaac.house.handler.ResponseHandler;
import com.isaac.house.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/isaacHouse")
public class UserController {

    private final UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseHandler.generateResponse(HttpStatus.OK, userService.createUser(user));
    }

    @GetMapping("/user/getAll")
    public ResponseEntity<?> getThings(){
        return ResponseHandler.generateResponse(HttpStatus.OK, userService.getAllUser());
    }

    @GetMapping("/user/get/{id}")
    public ResponseEntity<?> fetchUserById(@PathVariable long id){
        return ResponseHandler.generateResponse(HttpStatus.OK, userService.getUserById(id));
    }

    @PutMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return ResponseHandler.generateResponse(HttpStatus.OK,user);
    }


    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        return ResponseHandler.generateResponse(HttpStatus.OK,userService.deleteUser(id));
    }

}
