package com.wipro.vehiclelog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.vehiclelog.entity.Vehicle;
import com.wipro.vehiclelog.service.VehicleService;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService movementService;

    @PostMapping("/move")
    public String moveVehicle(@RequestBody Vehicle movement) 
    {
        movementService.saveMovement(movement);
        return "Vehicle movement saved successfully!";
    }
}
