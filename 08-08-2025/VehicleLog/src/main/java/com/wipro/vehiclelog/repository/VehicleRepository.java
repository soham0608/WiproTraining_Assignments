package com.wipro.vehiclelog.repository;

import com.wipro.vehiclelog.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
