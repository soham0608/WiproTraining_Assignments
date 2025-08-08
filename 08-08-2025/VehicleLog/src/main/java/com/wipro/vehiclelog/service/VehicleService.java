package com.wipro.vehiclelog.service;

import com.wipro.vehiclelog.entity.Vehicle;
import com.wipro.vehiclelog.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Vehicle saveMovement(Vehicle movement) 
    {
        return repository.save(movement);
    }
}
