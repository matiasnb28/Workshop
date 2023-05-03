package com.example.PersonalWorkshop.repository;

import com.example.PersonalWorkshop.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    //Budget findById(Long id);

    Budget findByVehicleId(Long id);
}
