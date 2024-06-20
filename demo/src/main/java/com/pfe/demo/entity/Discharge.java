package com.pfe.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discharge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private String destination ;
    private LocalDateTime createdAt;

    @ElementCollection
    private List<Integer> selectedInterventions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discharge")
    private Set<Intervention> interventions;
    @ManyToOne
    UserInfo userInfo;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
