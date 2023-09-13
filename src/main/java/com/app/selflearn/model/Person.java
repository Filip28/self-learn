package com.app.selflearn.model;

import jakarta.persistence.*;
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

    private String name;

    private String surname;

    private int age;

    private double height;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL
    )
    @Builder.Default
    private Set<Address> addresses = new HashSet<>();
}