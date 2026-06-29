package com.example.Karaikadeeshwarar.repo;

import com.example.Karaikadeeshwarar.model.Renovation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RenovationRepo extends JpaRepository<Renovation,Integer> {

    List<Renovation> findByStatusNot(String status);

}