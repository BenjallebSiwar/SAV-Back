package com.pfe.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    private Set<Intervention> interventions ;



}
