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
    private String panneType ;
    private String accessories ;
    private String description ;
    private LocalDateTime createdAt ;
    private Integer status ;
    private String workflow ;
    private String batterie ;
    private String etatTerminal ;
    private String terminalDePret ;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Swap_status> Swap_statuses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Swap> Swaps;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Available_client> Available_clients;

    @ManyToOne
    @JoinColumn(name = "client_cin", referencedColumnName = "cin", nullable = true)
    Client client;
    @ManyToOne
    @JoinColumn(name = "device_imei", referencedColumnName = "imei")
    Device device;
    @ManyToOne
    Discharge discharge;
    @ManyToOne
    UserInfo userInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Intervention_status> intervention_statuses;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }


}
