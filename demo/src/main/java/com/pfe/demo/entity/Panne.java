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
public class Panne {
    @Id
    @GeneratedValue
    private Long id ;
    private  String nom ;
    @ManyToMany
   private Set<Intervention> interventions ;
}
