package com.isaac.house.controller;

import com.isaac.house.entity.Drawer;
import com.isaac.house.handler.ResponseHandler;
import com.isaac.house.service.DrawerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/isaacHouse")
public class DrawerController {

    private final DrawerService drawerService;

    /* TODO: Please uncomment once Room Entity and repository added


    @PostMapping("/drawer/create")
    public ResponseEntity<?> createDrawer(@RequestParam Long id, @RequestBody Drawer drawer) {
        try {
            Drawer createdDrawer = drawerService.createDrawer(id,drawer);
            return ResponseHandler.generateResponse(HttpStatus.OK, createdDrawer);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    */

    @PutMapping("/drawer/updateStorage")
    public ResponseEntity<?> updateStorage(@RequestParam Long drawerId, @RequestParam Long thingsId){
        try {
            Drawer updateStorage = drawerService.updateStorageLeft(drawerId,thingsId);
            return ResponseHandler.generateResponse(HttpStatus.OK, updateStorage);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
