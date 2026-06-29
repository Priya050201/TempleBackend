package com.example.Karaikadeeshwarar.controller;

import com.example.Karaikadeeshwarar.model.Donation;
import com.example.Karaikadeeshwarar.service.DonationService;
//import com.example.Karaikadeeshwarar.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/donation")
//@CrossOrigin
public class DonationController {

    @Autowired
    private DonationService service;

//    @Autowired
//    private AdminService adminService;


    // PUBLIC sends donation request
    @PostMapping("/request")
    public Donation requestDonation(
            @Valid @RequestBody Donation donation) {

        System.out.println("DONATION API HIT");

        return service.requestDonation(donation);
    }


    // ADMIN sees pending donations
    @GetMapping("/pending")
    public List<Donation> getPendingDonations() {

//        if(!adminService.isLoggedIn()) {
//            return null;
//        }

        return service.getPendingDonations();
    }


    // ADMIN accepts donation after payment verification
    @PutMapping("/accept/{id}")
   // @PutMapping("/accept/{id}")
    public String acceptDonation(
            @PathVariable int id,

            @RequestParam String verifiedBy
    ) {

        return service.acceptDonation(id, verifiedBy);
    }


    // ADMIN sees accepted donations
    @GetMapping("/accepted")
    public List<Donation> getAcceptedDonations() {

//        if(!adminService.isLoggedIn()) {
//            return null;
//        }

        return service.getAcceptedDonations();
    }


    // ADMIN deletes donation
    @DeleteMapping("/delete/{id}")
    public String deleteDonation(@PathVariable int id) {

//        if(!adminService.isLoggedIn()) {
//            return "Admin login required";
//        }

        return service.deleteDonation(id);
    }


    // PUBLIC gets contact details for payment
    @GetMapping("/contact")
    public Map<String, String> getContactDetails() {

        return Map.of(
                "adminName", "Temple Admin",
                "phone", "9876543210",
                "upiId", "temple@upi"
        );
    }
    @PutMapping("/reject/{id}")
    public String rejectDonation(
            @PathVariable int id){

        return service.rejectDonation(id);
    }
}