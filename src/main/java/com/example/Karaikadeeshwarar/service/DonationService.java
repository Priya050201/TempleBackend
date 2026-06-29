package com.example.Karaikadeeshwarar.service;

import com.example.Karaikadeeshwarar.model.Donation;
import com.example.Karaikadeeshwarar.repo.DonationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepo repo;

    // Public submits request
    public Donation requestDonation(Donation donation){





        donation.setPaymentStatus("PENDING");

        donation.setDonatedAt(LocalDateTime.now());

        return repo.save(donation);
    }
    // Admin sees pending donations
    public List<Donation> getPendingDonations() {
        return repo.findByPaymentStatus("PENDING");
    }

    // Admin accepts after payment verification
    @Transactional
    public String acceptDonation(int id, String verifiedBy) {

        Donation donation = repo.findById(id).orElse(null);

        if (donation != null) {

            donation.setPaymentStatus("ACCEPTED");
            donation.setVerifiedBy(verifiedBy);
            donation.setVerifiedAt(LocalDateTime.now());

            repo.save(donation);

            return "Donation Accepted";
        }

        return "Donation not found";
    }

    // Admin sees accepted donations
    public List<Donation> getAcceptedDonations() {
        return repo.findByPaymentStatus("ACCEPTED");
    }

    public String deleteDonation(int id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Donation deleted";
        }

        return "Donation ID not found";
    }
    public String rejectDonation(int id){

        Donation donation = repo.findById(id).orElse(null);

        if(donation == null){
            return "Donation not found";
        }

        donation.setPaymentStatus("REJECTED");

        repo.save(donation);

        return "Donation rejected";
    }
}