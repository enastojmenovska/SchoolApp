package com.damilah.tech.school.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;


    public Professor() {
    }

    public Professor(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


}
