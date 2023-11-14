package com.isaac.house.service;

import com.isaac.house.entity.Drawer;
import com.isaac.house.entity.Thing;
import com.isaac.house.repository.DrawerRepo;
import com.isaac.house.repository.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrawerService {

    private final DrawerRepo drawerRepo;

    private final RoomRepo roomRepo;

    private final ThingService thingService;

    private static final Logger log = LoggerFactory.getLogger(DrawerService.class);

    public List<Drawer> getAllDrawer(){
        return drawerRepo.findAll();
    }

    public Drawer getDrawerById(long id){
        return drawerRepo.findById(id).orElse(null);
    }

    /* TODO: Please uncomment once Room Entity and repository added

    public Drawer createDrawer(Long roomId,Drawer drawer){
        Drawer addDrawer = new Drawer();
        String category = drawer.getCategory();

        // Fetch the room from the database using roomId
        // Uncomment once Room entity and repo created
        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId)
                );

        addDrawer.setRoomID(roomId);
        addDrawer.setRoomName(room.getRoomName());
        addDrawer.setCategory(drawer.getCategory());

        //When create new Drawer, storageLeft default according to the category
        addDrawer.setStorageLeft(getDefaultStorageLeft(category));
        //save into database
        drawerRepo.save(addDrawer);

        return addDrawer;
    }

     */

    private int getDefaultStorageLeft(String category) {
        // Set default storageLeft based on the category
        return switch (category) {
            case "A" -> 10;
            case "B" -> 20;
            case "C" -> 50;
            default -> throw new IllegalArgumentException("Invalid category: " + category);
        };
    }

    public Drawer updateStorageLeft(Long drawerId, Long thingsId) {
        //Drawer addDrawer = new Drawer();

        // Fetch the drawer from the database using drawerId
        Drawer drawer = drawerRepo.findById(drawerId)
                .orElseThrow(() -> new RuntimeException("Drawer not found with ID: " + drawerId)
                );

        Thing thing = thingService.getThingById(thingsId);

        if(thing != null && drawer != null) {
            int storageLeft = drawer.getStorageLeft();
            int thingSize = thing.getSize();

            storageLeft -= thingSize;
            log.debug("storage left: "+ storageLeft);
            drawer.setStorageLeft(storageLeft);
            drawer.setDrawerID(thingsId);
            drawer.setThingsName(thing.getThingsName());

        }
        else
            throw new RuntimeException("Things not found with ID: "+ thingsId);

        return drawer;

    }

}
