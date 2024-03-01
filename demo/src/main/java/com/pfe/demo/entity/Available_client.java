package com.pfe.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Available_client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String shop;
    private String comment;
    @ManyToOne
    Intervention intervention;

}
