package com.isaac.house.controller;

import com.isaac.house.service.DrawerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/isaacHouse")
public class DrawerController {

    private final DrawerService drawerService;

    /* TODO: Please uncomment once Room Entity and repository added


    @PostMapping("/drawer/create/{id}")
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

}
