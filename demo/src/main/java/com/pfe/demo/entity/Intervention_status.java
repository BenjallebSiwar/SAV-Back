package com.pfe.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intervention_status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer status;
    private LocalDateTime createdAt;
    private String local;
        private String amount;
        private String marque;
        private String modele;
        private Long newIMEI;
        private String pdfLink;

    @ManyToOne
    Intervention intervention;
}
