package com.pfe.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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


    private String description ;
    private LocalDateTime createdAt ;
    private String etat ;
    private String workflow ;
    private String batterie ;
    private String etatTerminal ;
    private String terminalDePret ;
    private String status;



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
    @JoinColumn(name = "discharge_id", referencedColumnName = "id", nullable = true)
    Discharge discharge;
    @ManyToOne
    UserInfo userInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private Set<Intervention_status> intervention_statuses;

//    @ManyToMany
    private Set<String> accessoires;
//    @ManyToMany
    private Set<String> pannes ;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public String getRepairType() {
        if ("externe".equalsIgnoreCase(workflow)) {
            return "En attente Envoi Réparateur externe";
        } else if ("interne".equalsIgnoreCase(workflow)) {
            return "En attente Envoi Réparateur interne";
        } else {
            return "En attente Envoi Workflow normal"; // Assuming "normal" or other cases should return a default value
        }
    }
    protected void Create() {
        if (etat == null) {
            etat = "en cours de diagnostic";
        }
        if (status == null) {
            status = "ouverte";
        }
    }
}
