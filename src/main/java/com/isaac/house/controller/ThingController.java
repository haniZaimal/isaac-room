package com.isaac.house.controller;

import com.isaac.house.entity.Thing;
import com.isaac.house.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThingController {

    @Autowired
    private ThingService thingService;

    @PostMapping("/thing/create")
    public Thing createDetails(@RequestBody Thing thing){
        return thingService.createThing(thing);
    }

}
