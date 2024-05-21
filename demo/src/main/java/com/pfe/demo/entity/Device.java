package com.pfe.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(max = 18)
    @Size(min = 18)
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



}
