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
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @NotBlank
    @Email
    private String email;
    private String roles;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfo")
    private Set<Intervention> interventions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfo")
    private Set<Discharge> discharges;

}
