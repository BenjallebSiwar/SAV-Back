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
public class Swap_status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String status;
    private String comment;
    private LocalDateTime createdAt;

    @ManyToOne
    Intervention intervention;
    @ManyToOne
    Swap swap;

}
