package com.example.Karaikadeeshwarar.controller;

import com.example.Karaikadeeshwarar.model.Home;
import com.example.Karaikadeeshwarar.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
//@CrossOrigin
public class HomeController {

    @Autowired
    private HomeService service;

    @GetMapping("/home")
    public Home getHomePage() {
        return service.getTempleInfo();
    }
}