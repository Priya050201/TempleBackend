package com.example.Karaikadeeshwarar.repo;

import com.example.Karaikadeeshwarar.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDateTime;

public interface DonationRepo extends JpaRepository<Donation,Integer>{

    List<Donation> findByPaymentStatus(String paymentStatus);


}