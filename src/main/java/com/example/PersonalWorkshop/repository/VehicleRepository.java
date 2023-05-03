package com.example.PersonalWorkshop.repository;

import com.example.PersonalWorkshop.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByPlate (String plate);

    Vehicle findByUserId(Long id);
}
