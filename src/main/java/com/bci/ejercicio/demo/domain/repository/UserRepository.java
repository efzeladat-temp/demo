package com.bci.ejercicio.demo.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bci.ejercicio.demo.domain.entity.User;

public interface UserRepository  extends JpaRepository<User, UUID>{

    @Query(value = "SELECT * FROM USER WHERE NAME = ?1", nativeQuery = true)
    Optional<User> findByCredentials(String username);

}
