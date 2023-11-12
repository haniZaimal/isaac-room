package com.isaac.house.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    // If ada better way to do this, pls advice huhu
    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("status", status.value());
            map.put("response", responseObj);
        } catch (Exception e) {
            e.printStackTrace();
            map.clear();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("response", responseObj);
        }
        return new ResponseEntity<>(map,status);
    }

}
