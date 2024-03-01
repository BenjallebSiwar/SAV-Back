package com.pfe.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long cin;
    private String firstName;

    private String lastName;
    @NotBlank
    @Email
    private String email;

    private String phoneNumber1;

    private String phoneNumber2;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Intervention> interventions;

}
