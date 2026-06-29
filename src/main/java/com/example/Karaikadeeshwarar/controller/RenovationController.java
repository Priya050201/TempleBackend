package com.example.Karaikadeeshwarar.controller;

import com.example.Karaikadeeshwarar.model.Renovation;
import com.example.Karaikadeeshwarar.service.RenovationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import com.example.Karaikadeeshwarar.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/renovation")
public class RenovationController {

    @Autowired
    private RenovationService service;
//    @Autowired
//    private AdminService adminService;

    // Add renovation work
    @PostMapping("/add")
    public String addRenovation(
            @Valid @RequestBody Renovation renovation) {
//        if(!adminService.isLoggedIn()) {
//            return "Admin login required";
//        }
        service.addRenovation(renovation);
        return "Renovation details added";
    }

    // Get all renovation works
    @GetMapping("/all")
    public List<Renovation> getAllRenovation() {
        return service.getAllRenovation();
    }

    // Update only status
    @PutMapping("/update/{id}")
    public String updateStatus(@PathVariable int id,
                                   @RequestBody Renovation renovation) {
//        if(!adminService.isLoggedIn()) {
//            return "Admin login required";
//        }
        return service.updateStatus(id, renovation);
        //return "Renovation details updated";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRenovation(@PathVariable int id) {
//        if(!adminService.isLoggedIn()) {
//            return "Admin login required";
//        }
        return service.deleteRenovation(id);
        //return "Renovation work deleted successfully";
    }
    @GetMapping("/public")
    public List<Renovation> getPublicRenovation() {
        return service.getPublicRenovation();
    }
}
