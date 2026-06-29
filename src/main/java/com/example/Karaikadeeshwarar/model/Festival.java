package com.example.Karaikadeeshwarar.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.*;


@Entity
@Table(name="festival")
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Festival name required")
    private String festivalName;

    @NotNull(message = "Festival date required")
    private LocalDate festivalDate;

    @NotBlank(message = "Description required")
    private String description;
    private String status;

    public Festival() {}

    public Festival(String festivalName,
                    LocalDate festivalDate,
                    String description) {

        this.festivalName = festivalName;
        this.festivalDate = festivalDate;
        this.description = description;
        //this.status = status;
    }

    public int getId() { return id; }

    public String getFestivalName() { return festivalName; }
    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public LocalDate getFestivalDate() { return festivalDate; }
    public void setFestivalDate(LocalDate festivalDate) {
        this.festivalDate = festivalDate;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}