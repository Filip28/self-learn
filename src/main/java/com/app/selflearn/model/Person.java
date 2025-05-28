package com.app.selflearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
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
    @JsonIgnore
    @ToString.Exclude // todo remove that when added address
    private Set<Address> addresses = new HashSet<>();
}