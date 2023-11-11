package com.isaac.house.service;

import com.isaac.house.entity.Thing;
import com.isaac.house.repository.ThingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThingService {

    @Autowired
    private ThingRepo thingRepo;

    public Thing createThing(Thing thing){
        return thingRepo.save(thing);
    }
}
