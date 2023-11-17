package com.isaac.house.service;

import com.isaac.house.entity.Drawer;
import com.isaac.house.entity.Room;
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

    public Drawer createDrawer(Long roomId,Drawer drawer){

        // Validate input
        if (drawer == null) {
            throw new IllegalArgumentException("Drawer cannot be null");
        }

        String category = drawer.getCategory();

        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Drawer category cannot be null or empty");
        }

        // Fetch the room from the database using roomId
        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));

        // Create a new drawer
        Drawer addDrawer = new Drawer();
        addDrawer.setRoomID(roomId);
        addDrawer.setRoomName(room.getRoomName());
        addDrawer.setCategory(category);

        // When creating a new Drawer, set storageLeft default according to the category
        addDrawer.setStorageLeft(getDefaultStorageLeft(category));

        // Save into the database
        drawerRepo.save(addDrawer);

        return addDrawer;
    }


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
            int quantity = thing.getQuantity();

            thingSize*=quantity;
            log.info("Thing size: "+ thingSize);
            storageLeft -= thingSize;
            log.info("storage left: "+ storageLeft);
            drawer.setStorageLeft(storageLeft);
            drawer.setThingID(thingsId);
            drawer.setThingsName(thing.getThingsName());

            drawerRepo.save(drawer);

        }
        else
            throw new RuntimeException("Things not found with ID: "+ thingsId);

        return drawer;

    }

}
