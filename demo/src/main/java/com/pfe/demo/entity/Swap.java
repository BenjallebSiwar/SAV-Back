package com.pfe.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Swap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private String imei;
    private String brand;
    private String model;
    private String price;
    private String status;

    @ManyToOne
    Intervention intervention;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "swap")
    private Set<Swap_status> swap_statuses;

}
