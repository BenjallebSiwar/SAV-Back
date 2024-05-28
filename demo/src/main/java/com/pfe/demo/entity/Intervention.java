package com.pfe.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private Long imei ;
    private Long clientId ;
    private String panneType ;
    private String accessories ;
    private String description ;
    private LocalDateTime createdAt ;
    private Integer status ;
    private String workflow ;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Swap_status> Swap_statuses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Swap> Swaps;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Available_client> Available_clients;

    @ManyToOne
    Client client;
    @ManyToOne
    Device device;
    @ManyToOne
    Discharge discharge;
    @ManyToOne
    UserInfo userInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Intervention_status> intervention_statuses;





}
