package com.app.selflearn.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
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
}