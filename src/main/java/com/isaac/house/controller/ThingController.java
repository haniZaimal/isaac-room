package com.isaac.house.controller;

import com.isaac.house.entity.Thing;
import com.isaac.house.handler.ResponseHandler;
import com.isaac.house.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/isaacHouse")
public class ThingController {


    // TODO: 11/11/2023 - to add handler for status that is not 200. 
    // TODO: 11/11/2023 - to show appropriate response for each action. 
    // TODO: 11/11/2023 - to add checking~ 
    @Autowired
    private ThingService thingService;

    @PostMapping("/thing/create")
    public ResponseEntity<Object> createThing(@RequestBody Thing thing){
        return ResponseHandler.generateResponse(HttpStatus.OK, thingService.createThing(thing));
    }

    @GetMapping("/thing/getAll")
    public ResponseEntity<Object> getThings(){
        return ResponseHandler.generateResponse(HttpStatus.OK, thingService.getAllThings());
    }

    @GetMapping("/thing/get/{id}")
    public ResponseEntity<Object> fetchThingById(@PathVariable long id){
        return ResponseHandler.generateResponse(HttpStatus.OK, thingService.getThingById(id));
    }

    @PutMapping("/thing/update")
    public ResponseEntity<Object> updateThing(@RequestBody Thing thing){
        return ResponseHandler.generateResponse(HttpStatus.OK,thing);
    }


    @DeleteMapping("/thing/delete/{id}")
    public ResponseEntity<Object> deleteThing(@PathVariable long id){
        return ResponseHandler.generateResponse(HttpStatus.OK,thingService.deleteThing(id));
    }

}
