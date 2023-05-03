package com.example.PersonalWorkshop.repository;

import com.example.PersonalWorkshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByfirstName(String firstName);

    User findByLastName(String lastName);

    User findByUserName(String userName);
}
