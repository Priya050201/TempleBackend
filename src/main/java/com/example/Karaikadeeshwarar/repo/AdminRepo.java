package com.example.Karaikadeeshwarar.repo;

import com.example.Karaikadeeshwarar.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

    Optional<Admin> findByUsername(String username);

}