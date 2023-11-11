package com.isaac.house.service;

import com.isaac.house.entity.Thing;
import com.isaac.house.repository.ThingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingService {

    @Autowired
    private ThingRepo thingRepo;

    public Thing createThing(Thing thing){
        return thingRepo.save(thing);
    }

    public List<Thing> getAllThings(){
        return thingRepo.findAll();
    }

    public Thing getThingById(long id){
        return thingRepo.findById(id).orElse(null);
    }

    public Thing updateThing(Thing thing){

        Thing updateThing = thingRepo.findById(thing.getThingID()).orElse(null);

        if(updateThing != null){
            updateThing.setThingsName(thing.getThingsName());
            updateThing.setSize(thing.getSize());
            updateThing.setQuantity(thing.getQuantity());
            updateThing.setStatus(thing.getStatus());
            updateThing.setDrawerID(thing.getDrawerID());
            thingRepo.save(updateThing);
            return updateThing;
        }

        return null;
    }

    public String deleteThing(long id){
        thingRepo.deleteById(id);
        return "deleted!";
    }

}
