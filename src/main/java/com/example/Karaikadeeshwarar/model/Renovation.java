package com.example.Karaikadeeshwarar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "renovation")
public class Renovation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Renovation name required")
    private String name;

    @NotBlank(message = "Description required")
    private String description;

    @NotBlank(message = "Status required")
    private String status;

    public Renovation() {
    }

    public Renovation(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

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