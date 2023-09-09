package com.app.selflearn.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private int age;

    @NotNull
    private double height;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL
    )
    private Set<Address> addresses = new HashSet<>();
}