package com.example.Karaikadeeshwarar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name="donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Donor name required")
    private String donorName;

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must be 10 digits"
    )
    private String phoneNumber;

    @NotBlank(message = "Purpose required")
    private String purpose;

    private String paymentStatus;
    private LocalDateTime donatedAt;

    private LocalDateTime verifiedAt;
   // @NotBlank(message="Name of the admin is mandatory to fill")
    private String verifiedBy;

    public Donation() {}

    public Donation(String donorName, double amount,
                    String phoneNumber, String purpose,
                    String paymentStatus, LocalDateTime donatedAt,
                    LocalDateTime verifiedAt, String verifiedBy) {

        this.donorName = donorName;
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.purpose = purpose;
        this.paymentStatus = paymentStatus;
        this.donatedAt = donatedAt;
        this.verifiedAt = verifiedAt;
        this.verifiedBy = verifiedBy;
    }

    public int getId() {
        return id;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public LocalDateTime getDonatedAt() {
        return donatedAt;
    }

    public void setDonatedAt(LocalDateTime donatedAt) {
        this.donatedAt = donatedAt;
    }
    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }
    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

}