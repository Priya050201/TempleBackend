package com.example.Karaikadeeshwarar.controller;

import com.example.Karaikadeeshwarar.model.Festival;
import com.example.Karaikadeeshwarar.service.FestivalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import com.example.Karaikadeeshwarar.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/festival")
//@CrossOrigin
public class FestivalController {

    @Autowired
    private FestivalService service;
//    @Autowired
//    private AdminService adminService;

    // Admin adds festival
    @PostMapping("/add")
    public String addFestival(
            @Valid @RequestBody Festival festival){
//        if(!adminService.isLoggedIn()) {
//            return "Admin login required";
//        }
        service.addFestival(festival);
        return "Festival Added";
    }

    // Public sees festivals
    @GetMapping("/active")

    public List<Festival> getActiveFestivals() {

        return service.getActiveFestivals();
    }

    // Admin removes festival
    @DeleteMapping("/delete/{id}")
    public String deleteFestival(@PathVariable int id){
//        if(!adminService.isLoggedIn()) {
//            return "Admin login required";
//        }
        return service.deleteFestival(id);
        //return "Festival deleted";
    }
    @PutMapping("/update/{id}")

    public String updateFestival(

            @PathVariable int id,

            @RequestBody Festival festival) {
//        if(!adminService.isLoggedIn()) {
//            return "Admin login required";
//        }

        return service.updateFestival(id, festival);
        //return "Festival Updated";
    }
    @GetMapping("/all")
    public List<Festival> getAllFestivals(){
        return service.getAllFestivals();
    }

}
