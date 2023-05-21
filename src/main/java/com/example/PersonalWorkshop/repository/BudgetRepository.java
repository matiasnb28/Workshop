package com.example.PersonalWorkshop.repository;

import com.example.PersonalWorkshop.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Optional<Budget> findById(Long id);

    Budget findByVehicleId(Long id);

    List<Budget> findBudgetsByVehicleId(Long id);
}
