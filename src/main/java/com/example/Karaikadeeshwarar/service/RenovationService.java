package com.example.Karaikadeeshwarar.service;

import com.example.Karaikadeeshwarar.model.Renovation;
import com.example.Karaikadeeshwarar.repo.RenovationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenovationService {

    @Autowired
    private RenovationRepo repo;

    // Add renovation work
    public Renovation addRenovation(Renovation renovation) {
        return repo.save(renovation);
    }

    // Get all renovation works
    public List<Renovation> getAllRenovation() {
        return repo.findAll();
    }

    // Update only status
    public String updateStatus(int id, Renovation updatedRenovation) {

        Renovation existingRenovation = repo.findById(id).orElse(null);

        if (existingRenovation != null) {

            existingRenovation.setName(
                    updatedRenovation.getName()
            );

            existingRenovation.setDescription(
                    updatedRenovation.getDescription()
            );

            existingRenovation.setStatus(
                    updatedRenovation.getStatus()
            );

            repo.save(existingRenovation);

            return "Renovation updated";
        }

        return "Renovation not found";
    }
    public String deleteRenovation(int id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted Successfully";
        }
        return "Id not found";
    }
    public List<Renovation> getPublicRenovation() {
        return repo.findByStatusNot("COMPLETED");
    }
}