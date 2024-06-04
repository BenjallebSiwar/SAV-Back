package com.pfe.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long imei ;
    private String brand ;
    private String model ;
    private String status;
    private String supplier ;
    private LocalDateTime purchase_date;
    private String batteryId;
    private Long nbRetourSav;
    private Long guarantee;
    private Long terminal ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    private Set<Intervention> interventions ;

    // Method to calculate remaining warranty period in months
    public long calculateRemainingWarranty() {
        LocalDateTime now = LocalDateTime.now();
        long months = ChronoUnit.MONTHS.between(purchase_date, now);
        return Math.max(guarantee - months, 0); // Ensure remaining warranty is not negative
    }


}
