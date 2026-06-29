package com.example.Karaikadeeshwarar.service;

import com.example.Karaikadeeshwarar.model.Festival;
import com.example.Karaikadeeshwarar.repo.FestivalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.List;

@Service
public class FestivalService {

    @Autowired
    private FestivalRepo repo;

    public Festival addFestival(Festival festival){

        updateStatusByDate(festival);

        return repo.save(festival);
    }

    public List<Festival> getAllFestivals(){

        List<Festival> festivals = repo.findAll();

        refreshFestivalStatus(festivals);

        return festivals;
    }

    public String deleteFestival(int id){

        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Festival deleted";
        }

        return "Festival not found";
    }
    public String updateFestival(int id, Festival updatedFestival) {

        Festival existingFestival = repo.findById(id).orElse(null);

        if(existingFestival != null) {

            if(updatedFestival.getFestivalName() != null) {
                existingFestival.setFestivalName(
                        updatedFestival.getFestivalName()
                );
            }

            if(updatedFestival.getFestivalDate() != null) {
                existingFestival.setFestivalDate(
                        updatedFestival.getFestivalDate()
                );
            }

            if(updatedFestival.getDescription() != null) {
                existingFestival.setDescription(
                        updatedFestival.getDescription()
                );
            }

            // Automatically update status based on date
            updateStatusByDate(existingFestival);

            repo.save(existingFestival);
            return "Festival updated";
        }

        return "Festival not found";
    }
    private void updateStatusByDate(Festival festival){

        if(festival.getFestivalDate() == null){
            throw new RuntimeException("Festival date is required");
        }

        LocalDate today = LocalDate.now();

        if(festival.getFestivalDate().isAfter(today)) {
            festival.setStatus("UPCOMING");
        }

        else if(festival.getFestivalDate().isEqual(today)) {
            festival.setStatus("ONGOING");
        }

        else {
            festival.setStatus("COMPLETED");
        }
    }
    public List<Festival> getActiveFestivals() {

        List<Festival> festivals = repo.findAll();

        refreshFestivalStatus(festivals);

        return festivals.stream()

                .filter(festival ->
                        !festival.getStatus()
                                .equalsIgnoreCase("COMPLETED")
                )

                .collect(Collectors.toList());
    }
    private void refreshFestivalStatus(List<Festival> festivals){

        for(Festival festival : festivals){

            String oldStatus = festival.getStatus();

            updateStatusByDate(festival);

            if(oldStatus == null ||
                    !festival.getStatus().equals(oldStatus)){

                repo.save(festival);
            }
        }
    }
}