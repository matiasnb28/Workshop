package com.example.PersonalWorkshop.repository;

import com.example.PersonalWorkshop.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByPlate (String plate);

    List<Vehicle> findByUserId(Long id);
}
