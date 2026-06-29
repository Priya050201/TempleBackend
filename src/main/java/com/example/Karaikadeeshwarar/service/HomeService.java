package com.example.Karaikadeeshwarar.service;

import com.example.Karaikadeeshwarar.model.Home;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public Home getTempleInfo() {

        return new Home(
                "Karaikandeeshwarar Temple",
                "Tamil Nadu , Tiruvannamalai dt , 606 702",
                "Ancient Shiva temple known for festivals and spiritual heritage"
        );
    }
}